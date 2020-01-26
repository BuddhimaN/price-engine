package com.retailsuper.priceengine.exception;

/**
 * Class for exception when config value is invalid
 *
 * @author BuddhimaN
 * @since 01/20
 */
public class InvalidSettingValueException extends RuntimeException{
    public InvalidSettingValueException(String message) {
        super(message);
    }
}
