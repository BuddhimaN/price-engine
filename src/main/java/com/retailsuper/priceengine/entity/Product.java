package com.retailsuper.priceengine.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique=true)
    private String productCode;

    @NotNull
    @NotEmpty
    private String productName;

    @NotNull
    @Min(value = 0)
    private Double cartonPrice;

    @NotNull
    @Min(value = 1)
    private Integer itemsPerCarton;
}
