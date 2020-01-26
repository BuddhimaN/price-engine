package com.retailsuper.priceengine.controller;

import com.retailsuper.priceengine.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Settings management
 *
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
@RequestMapping("/api/v1/settings")
public class SettingsController {

    @Autowired
    SettingsService settingsService;

    @PutMapping("/unitProcessingPercentage/{unitProcessingPercentage}")
    public ResponseEntity<String> updateSingleUnitPercentage(@PathVariable Double unitProcessingPercentage){
        String value = settingsService.updateUnitProcessingPercentage(unitProcessingPercentage);
        return new ResponseEntity("Successfully updated unit processing percentage value: "+ value, HttpStatus.OK);
    }

    @PutMapping("/offerPercentage/{offerPercentage}")
    public ResponseEntity<String> updateOfferPercentage(@PathVariable Double offerPercentage){
        String value = settingsService.updateOfferPercentage(offerPercentage);
        return new ResponseEntity("Successfully updated offer percentage value: "+ value, HttpStatus.OK);
    }

    @PutMapping("/offerQuantity/{offerQuantity}")
    public ResponseEntity<String> updateOfferQuantity(@PathVariable Integer offerQuantity){
        String value = settingsService.updateOfferQuantity(offerQuantity);
        return new ResponseEntity("Successfully updated offer quantity value: "+ value, HttpStatus.OK);
    }
}
