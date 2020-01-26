package com.retailsuper.priceengine.price;

import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.util.QuantityCalculator;

/**
 * Class to calculate price for carton items
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class CartonPrice extends PriceDecorator {
    private Double offerPercentage;
    private int offerQuantity;

    public CartonPrice(PriceCalculator calculator, Double offerPercentage, int offerQuantity) {
        super(calculator);
        this.offerPercentage = offerPercentage;
        this.offerQuantity = offerQuantity;
    }

    @Override
    public PriceDatatDTO calculate(ProductDTO product, PriceDatatDTO priceData) {
        PriceDatatDTO calculatedData = super.calculate(product, priceData);
        QuantityCalculator.calculateCartoonCount(product, calculatedData);
        if (calculatedData.getCartonCount() > 0) {
            int cartonCount = calculatedData.getCartonCount();
            double totalPrice;
            if (cartonCount >= offerQuantity) {
                double newCartonPrice = product.getCartonPrice() - (product.getCartonPrice() * (offerPercentage/100));
                totalPrice = newCartonPrice * calculatedData.getCartonCount();
            } else {
                totalPrice = product.getCartonPrice() * calculatedData.getCartonCount();
            }
            calculatedData.setPrice(calculatedData.getPrice() + totalPrice);
        }
        return calculatedData;
    }
}
