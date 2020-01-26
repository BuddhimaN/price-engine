package com.retailsuper.priceengine.exception;

/**
 * Class for exception when product is not available
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String productCode) {
        super("Product is not available for " + productCode);
    }
}
