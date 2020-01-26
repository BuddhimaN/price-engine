package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.entity.Setting;
import com.retailsuper.priceengine.exception.InvalidSettingValueException;
import com.retailsuper.priceengine.repository.SettingsRepository;
import com.retailsuper.priceengine.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingsService {

    @Autowired
    SettingsRepository repository;

    @Override
    public String updateUnitProcessingPercentage(Double percentage) {
        if(percentage < 0){
            throw new InvalidSettingValueException("Unit processing percentage should be a positive value");
        }
        Setting setting = repository.findByCode(Setting.UNIT_PROCESSING_PERCENTAGE);
        setting.setValue(String.valueOf(percentage));
        Setting updatedSetting = repository.save(setting);
        return updatedSetting.getValue();
    }

    @Override
    public String updateOfferPercentage(Double percentage) {
        if(percentage < 0){
            throw new InvalidSettingValueException("Offer percentage should be a positive value");
        }
        Setting setting = repository.findByCode(Setting.OFFER_PERCENTAGE);
        setting.setValue(String.valueOf(percentage));
        Setting updatedSetting = repository.save(setting);
        return updatedSetting.getValue();
    }

    @Override
    public String updateOfferQuantity(Integer percentage) {
        if(percentage < 0){
            throw new InvalidSettingValueException("Offer quantity should be a positive value");
        }
        Setting setting = repository.findByCode(Setting.MINUMUM_OFFER_QUANTITY);
        setting.setValue(String.valueOf(percentage));
        Setting updatedSetting = repository.save(setting);
        return updatedSetting.getValue();
    }
}
