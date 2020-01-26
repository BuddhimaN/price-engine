package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;

/**
 * Decorator Class for Price calculation
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class PriceDecorator implements PriceCalculator{

    PriceCalculator calculator;

    public PriceDecorator(PriceCalculator calculator){
        this.calculator=calculator;
    }

    @Override
    public PriceDatatDTO calculate(ProductDTO product, PriceDatatDTO priceData) {
        return this.calculator.calculate(product,priceData);
    }
}
