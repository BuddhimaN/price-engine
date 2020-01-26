package com.retailsuper.priceengine.exception;
/**
 * Class for exception when adding already existing product
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class DuplicateProductException extends RuntimeException{
    public DuplicateProductException(String productCode) {
        super("Product is already available with the product code : " + productCode);
    }
}
