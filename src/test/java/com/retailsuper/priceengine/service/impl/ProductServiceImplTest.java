package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import com.retailsuper.priceengine.mapper.ProductMapper;
import com.retailsuper.priceengine.repository.ProductRepository;
import com.retailsuper.priceengine.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class ProductServiceImplTest {

    @InjectMocks
    @Autowired
    ProductService productService = new ProductServiceImpl();

    @Mock
    ProductRepository repository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Test
    void addProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode("CODE2");
        productDTO.setProductName("Sample2");
        productDTO.setCartonPrice(150.00);
        productDTO.setItemsPerCarton(20);

        Product product = mapper.toEntity(productDTO);

        Mockito.when(repository.findByProductCode(productDTO.getProductCode()))
                .thenReturn(Optional.empty());
        Mockito.when(repository.save(product))
                .thenReturn(product);

        MockitoAnnotations.initMocks(this);

        productService.addProduct(productDTO);
        verify(repository, times(2));
    }

    void updateProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductCode("CODE2");
        productDTO.setProductName("update");
        productDTO.setCartonPrice(150.00);
        productDTO.setItemsPerCarton(20);

        Product product = mapper.toEntity(productDTO);

        Mockito.when(repository.findByProductCode(productDTO.getProductCode()))
                .thenReturn(Optional.of(product));
        Mockito.when(repository.save(product))
                .thenReturn(product);

        productService.updateProduct(productDTO);
        verify(repository, times(1));
    }
}