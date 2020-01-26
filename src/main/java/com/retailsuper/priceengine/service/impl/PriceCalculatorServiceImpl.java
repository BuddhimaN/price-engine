package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import com.retailsuper.priceengine.entity.Setting;
import com.retailsuper.priceengine.exception.ProductNotFoundException;
import com.retailsuper.priceengine.mapper.ProductMapper;
import com.retailsuper.priceengine.price.BasePrice;
import com.retailsuper.priceengine.price.CartonPrice;
import com.retailsuper.priceengine.price.PriceCalculator;
import com.retailsuper.priceengine.price.UnitPrice;
import com.retailsuper.priceengine.repository.ProductRepository;
import com.retailsuper.priceengine.repository.SettingsRepository;
import com.retailsuper.priceengine.service.PriceCalculatorService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceCalculatorServiceImpl implements PriceCalculatorService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SettingsRepository settingsRepository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public PriceDatatDTO calculatePrice(PriceDatatDTO priceData) {
        double offerPercentage = Double.parseDouble(settingsRepository.findByCode(Setting.OFFER_PERCENTAGE).getValue());
        int offerQuantity = Integer.parseInt(settingsRepository.findByCode(Setting.MINUMUM_OFFER_QUANTITY).getValue());
        double unitProcessingPercentage = Double.parseDouble(settingsRepository.findByCode(
                Setting.UNIT_PROCESSING_PERCENTAGE).getValue());

        Product product = productRepository.findByProductCode(priceData.getProductCode())
                .orElseThrow(()->new ProductNotFoundException(priceData.getProductCode()));
        ProductDTO productDTO = mapper.toDTO(product);

        PriceCalculator priceCalculator = new UnitPrice(new CartonPrice(new BasePrice(), offerPercentage,
                                                                offerQuantity), unitProcessingPercentage);
        return priceCalculator.calculate(productDTO,priceData);
    }
}
