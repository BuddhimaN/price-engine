package com.retailsuper.priceengine.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * DTO Class for sending Price Result
 * @author BuddhimaN
 * @since 01/20
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@JacksonXmlRootElement(localName = "Result")
public class PriceDatatDTO {
    @NotNull
    private String productCode;
    @Min(value = 0)
    private Double price;
    @Min(value = 0)
    private Integer unitCount;
    @Min(value = 0)
    private Integer cartonCount;
}
