package com.retailsuper.priceengine.service;

/**
 * Interface for Settings Service
 *
 * @author BuddhimaN
 * @since 01/20
 */
public interface SettingsService {

    String updateUnitProcessingPercentage(Double percentage);
    String updateOfferPercentage(Double percentage);
    String updateOfferQuantity(Integer percentage);
}
