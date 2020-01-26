package com.retailsuper.priceengine.service;

import com.retailsuper.priceengine.dto.PriceDatatDTO;

/**
 * Interface for price calculator Service
 *
 * @author BuddhimaN
 * @since 01/20
 */

public interface PriceCalculatorService {
    PriceDatatDTO calculatePrice(PriceDatatDTO datatDTO);
}
