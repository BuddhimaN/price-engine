package com.retailsuper.priceengine.service.impl;

import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.entity.Product;
import com.retailsuper.priceengine.exception.DuplicateProductException;
import com.retailsuper.priceengine.exception.ProductNotFoundException;
import com.retailsuper.priceengine.mapper.ProductMapper;
import com.retailsuper.priceengine.repository.ProductRepository;
import com.retailsuper.priceengine.service.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementation class of Product Service
 *
 * @author BuddhimaN
 * @since 01/20
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    @Override
    public ProductDTO addProduct(@NotNull @Valid ProductDTO product) {
        Product newProduct = mapper.toEntity(product);
        Optional<Product> existingProduct = repository.findByProductCode(product.getProductCode());
        if(existingProduct.isPresent()){
            throw new DuplicateProductException(product.getProductCode());
        }
        return mapper.toDTO(repository.save(newProduct));
    }

    @Override
    public ProductDTO updateProduct(@NotNull @Valid ProductDTO product) {
        Product newProduct = mapper.toEntity(product);
        Product existingProduct = repository.findByProductCode(product.getProductCode())
                .orElseThrow(() -> new ProductNotFoundException(product.getProductCode()));
        newProduct.setId(existingProduct.getId());
        return mapper.toDTO(repository.save(newProduct));
    }

    @Override
    public ProductDTO getProduct(@NotNull @NotEmpty String productCode) {
        Product product = repository.findByProductCode(productCode)
                .orElseThrow(() -> new ProductNotFoundException(productCode));
        return mapper.toDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Product> pagedResult = repository.findAll(paging);
        if (pagedResult.hasContent()) {
            return mapper.toDTOList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteProduct(@NotNull @NotEmpty String productCode) {
        Product product = repository.findByProductCode(productCode)
                .orElseThrow(() -> new ProductNotFoundException(productCode));
        repository.delete(product);
    }
}
