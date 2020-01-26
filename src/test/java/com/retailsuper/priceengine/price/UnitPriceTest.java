package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import com.retailsuper.priceengine.repository.ProductRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UnitPriceTest {

    @Mock
    PriceCalculator previousCalculator;


    private Double unitProcessingPercentage = 30.0;

    @InjectMocks
    PriceCalculator calculator = new UnitPrice(previousCalculator,unitProcessingPercentage);

    private ProductDTO productDTO;
    private PriceDatatDTO priceDatatDTO;

    @Before
    public void setup(){

        productDTO = new ProductDTO();
        productDTO.setProductCode("CODE2");
        productDTO.setProductName("Sample2");
        productDTO.setCartonPrice(100.00);
        productDTO.setItemsPerCarton(10);

        priceDatatDTO = new PriceDatatDTO();
        priceDatatDTO.setProductCode("CODE2");
        priceDatatDTO.setPrice(0.0);
        priceDatatDTO.setUnitCount(5);
        priceDatatDTO.setCartonCount(10);

        MockitoAnnotations.initMocks(this);
        Mockito.when(previousCalculator.calculate(productDTO,priceDatatDTO))
                .thenReturn(priceDatatDTO);
    }

    @Test
    public void calculate() {
        PriceDatatDTO calculatedPrice = calculator.calculate(productDTO, priceDatatDTO);
        assertEquals(65.0,calculatedPrice.getPrice().doubleValue(),0);
    }
}