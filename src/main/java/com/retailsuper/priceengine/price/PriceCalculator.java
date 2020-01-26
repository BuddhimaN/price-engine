package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
/**
 * Component Interface for price calculation
 *
 * @author BuddhimaN
 * @since 01/20
 */
public interface PriceCalculator {
    PriceDatatDTO calculate(ProductDTO product, PriceDatatDTO priceData);
}
