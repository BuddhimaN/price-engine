package com.retailsuper.priceengine.mapper;

import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import org.mapstruct.Mapper;
import java.util.List;

/**
 * Mapper for data conversions between DTO and Entity
 *
 * @author BuddhimaN
 * @since 01/20
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO product);
    List<ProductDTO> toDTOList(List<Product> productList);
}
