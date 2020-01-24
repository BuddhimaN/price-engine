package com.retailsuper.priceengine.controller;

import com.retailsuper.priceengine.dto.PriceResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for price calculation
 *
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
@RequestMapping("/api/v1/price")
public class PriceCalculationController {

    @GetMapping("/{productCode}")
    public ResponseEntity<PriceResultDTO> calculatePrice(@PathVariable(name = "productCode") String productCode,
                                                         @RequestParam(name = "units") int units,
                                                         @RequestParam(name = "cartons") int cartons){
        PriceResultDTO resultDTO =  new PriceResultDTO();
        return new ResponseEntity<>(resultDTO, HttpStatus.OK);
    }
}
