package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import com.retailsuper.priceengine.entity.Setting;
import com.retailsuper.priceengine.mapper.ProductMapper;
import com.retailsuper.priceengine.repository.ProductRepository;
import com.retailsuper.priceengine.repository.SettingsRepository;
import com.retailsuper.priceengine.service.PriceCalculatorService;
import com.retailsuper.priceengine.service.ProductService;
import com.retailsuper.priceengine.service.SettingsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PriceCalculatorServiceImplTest {


    @InjectMocks
    @Autowired
    PriceCalculatorService service = new PriceCalculatorServiceImpl();

    @Mock
    ProductRepository repository;

    @Mock
    SettingsRepository settingsRepository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Before
    public void setup(){
        Setting offerPercentageSetting = new Setting(Setting.OFFER_PERCENTAGE,"10");
        Setting offerQuantity = new Setting(Setting.MINUMUM_OFFER_QUANTITY,"3");
        Setting unitProcessingPercentage = new Setting(Setting.UNIT_PROCESSING_PERCENTAGE,"10");
        Mockito.when(settingsRepository.findByCode(Setting.OFFER_PERCENTAGE))
                .thenReturn(offerPercentageSetting);
        Mockito.when(settingsRepository.findByCode(Setting.MINUMUM_OFFER_QUANTITY))
                .thenReturn(offerQuantity);
        Mockito.when(settingsRepository.findByCode(Setting.UNIT_PROCESSING_PERCENTAGE))
                .thenReturn(unitProcessingPercentage);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode("CODE2");
        productDTO.setProductName("update");
        productDTO.setCartonPrice(100.0);
        productDTO.setItemsPerCarton(10);

        Product product = mapper.toEntity(productDTO);

        Mockito.when(repository.findByProductCode(productDTO.getProductCode()))
                .thenReturn(Optional.of(product));

        MockitoAnnotations.initMocks(this);
    }

    public void calculatePrice() {
        PriceDatatDTO priceDatatDTO = new PriceDatatDTO();
        priceDatatDTO.setProductCode("CODE2");
        priceDatatDTO.setCartonCount(10);
        priceDatatDTO.setUnitCount(55);

        PriceDatatDTO result = service.calculatePrice(priceDatatDTO);
        assertEquals(1415.0,result.getPrice(),0);
    }
}