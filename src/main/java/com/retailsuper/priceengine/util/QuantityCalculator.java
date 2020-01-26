package com.retailsuper.priceengine.util;


import com.retailsuper.priceengine.dto.PriceDatatDTO;
import com.retailsuper.priceengine.dto.ProductDTO;

import javax.validation.Valid;

public class QuantityCalculator {

    private QuantityCalculator(){
        //hiding implicit public constructor
    }

    public static void calculateCartoonCount(@Valid ProductDTO productDTO, @Valid PriceDatatDTO resultDTO){
        if(resultDTO.getUnitCount() > productDTO.getItemsPerCarton()){
            int cartonCount = resultDTO.getUnitCount()/productDTO.getItemsPerCarton();
            int unitCount = resultDTO.getUnitCount()%productDTO.getItemsPerCarton();
            resultDTO.setCartonCount(resultDTO.getCartonCount()+cartonCount);
            resultDTO.setUnitCount(unitCount);
        }
    }
}
