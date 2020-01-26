package com.retailsuper.priceengine.service;

import com.retailsuper.priceengine.dto.ProductDTO;

import java.util.List;

/**
 * Interface for product Service
 *
 * @author BuddhimaN
 * @since 01/20
 */

public interface ProductService {
    ProductDTO addProduct(ProductDTO product);
    ProductDTO updateProduct(ProductDTO product);
    ProductDTO getProduct(String productCode);
    List<ProductDTO> getAllProducts(Integer pageNo,Integer pageSize,String sortBy);
    void deleteProduct(String productCode);
}
