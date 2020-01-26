package com.retailsuper.priceengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Entity Class for Product
 *
 * @author BuddhimaN
 * @since 01/20
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Setting {

    public static final String UNIT_PROCESSING_PERCENTAGE ="UPP";
    public static final String MINUMUM_OFFER_QUANTITY ="MOQ";
    public static final String OFFER_PERCENTAGE ="OP";


    @Id
    @NotNull
    private String code;

    @NotNull
    private String value;

}
