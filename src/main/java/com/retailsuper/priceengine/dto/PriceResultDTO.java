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
public class PriceResultDTO {
    @NotNull
    private String productCode;
    @NotNull
    @Min(value = 0)
    private Double price;
    @NotNull
    @Min(value = 0)
    private Integer unitCount;
    @NotNull
    @Min(value = 0)
    private Integer cartonCount;
}
