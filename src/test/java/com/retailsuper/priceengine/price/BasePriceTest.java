package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BasePriceTest {


    @InjectMocks
    PriceCalculator calculator = new BasePrice();

    @Test
    public void calculate() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode("CODE2");
        productDTO.setProductName("Sample2");
        productDTO.setCartonPrice(100.00);
        productDTO.setItemsPerCarton(10);

        PriceDatatDTO priceDatatDTO = new PriceDatatDTO();
        priceDatatDTO.setProductCode("CODE2");
        priceDatatDTO.setPrice(0.0);
        priceDatatDTO.setUnitCount(55);
        priceDatatDTO.setCartonCount(10);

        PriceDatatDTO calculate = calculator.calculate(productDTO, priceDatatDTO);
        assertEquals(priceDatatDTO,calculate);
    }
}