package com.retailsuper.priceengine.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * DTO Class for Product
 * @author BuddhimaN
 * @since 01/20
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JacksonXmlRootElement(localName = "Product")
public class ProductDTO {
    @NotNull
    @NotEmpty
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
