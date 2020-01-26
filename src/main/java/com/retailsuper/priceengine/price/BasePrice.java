package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;

/**
 * Concrete component Class for price calculation
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class BasePrice  implements PriceCalculator{

    @Override
    public PriceDatatDTO calculate(ProductDTO product, PriceDatatDTO priceData) {
        return priceData;
    }
}
