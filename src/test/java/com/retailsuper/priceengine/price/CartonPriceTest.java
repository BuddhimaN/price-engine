package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class CartonPriceTest {

    @Mock
    PriceCalculator previousCalculator;

    private Double offerPercentage = 10.0;
    private int offerQuantity = 3;

    @InjectMocks
    PriceCalculator calculator = new CartonPrice(previousCalculator,offerPercentage,offerQuantity);

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
        priceDatatDTO.setCartonCount(15);

        MockitoAnnotations.initMocks(this);
        Mockito.when(previousCalculator.calculate(productDTO,priceDatatDTO))
                .thenReturn(priceDatatDTO);
    }
    @Test
    public void calculate() {
        PriceDatatDTO calculatedPrice = calculator.calculate(productDTO, priceDatatDTO);
        assertEquals(1350.0,calculatedPrice.getPrice().doubleValue(),0);
    }
}