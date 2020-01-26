package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;

/**
 * Decorator class to calculate price for single units
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class UnitPrice extends PriceDecorator {

    private Double unitProcessingPercentage;

    public UnitPrice(PriceCalculator calculator, Double unitProcessingPercentage) {
        super(calculator);
        this.unitProcessingPercentage = unitProcessingPercentage;
    }

    @Override
    public PriceDatatDTO calculate(ProductDTO product, PriceDatatDTO priceData) {
        PriceDatatDTO calculatedData = super.calculate(product, priceData);
        if (calculatedData.getUnitCount() > 0) {
            double baseUnitPrice = product.getCartonPrice() / product.getItemsPerCarton();
            double actualUnitPrice = baseUnitPrice + (baseUnitPrice * (unitProcessingPercentage/100));
            calculatedData.setPrice(calculatedData.getPrice() + (actualUnitPrice * calculatedData.getUnitCount()));
        }
        return calculatedData;
    }
}
