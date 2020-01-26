package com.retailsuper.priceengine.controller;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.service.PriceCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;

/**
 * Controller for price calculation
 *
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
@RequestMapping("/api/v1/price")
public class PriceCalculationController {

    @Autowired
    PriceCalculatorService service;

    @GetMapping("/{productCode}")
    public ResponseEntity<PriceDatatDTO> calculatePrice(@NotEmpty  @PathVariable(name = "productCode") String productCode,
                                                        @RequestParam(name = "units",defaultValue = "0") Integer units,
                                                        @RequestParam(name = "cartons",defaultValue = "0") Integer cartons){
        PriceDatatDTO priceDatatDTO =  new PriceDatatDTO();
        priceDatatDTO.setProductCode(productCode);
        priceDatatDTO.setCartonCount(cartons);
        priceDatatDTO.setUnitCount(units);
        priceDatatDTO.setPrice(0.0);
        return new ResponseEntity<>(service.calculatePrice(priceDatatDTO), HttpStatus.OK);
    }
}
