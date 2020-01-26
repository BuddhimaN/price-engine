package com.retailsuper.priceengine.controller;

import com.retailsuper.priceengine.dto.ProductDTO;
import com.retailsuper.priceengine.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller Class for Products
 *
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@Valid  @RequestBody ProductDTO product) {
        return new ResponseEntity(productService.addProduct(product), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody ProductDTO product){
        return new ResponseEntity(productService.updateProduct(product),HttpStatus.OK);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(name = "productCode") String procuctCode){
        return new ResponseEntity<>(productService.getProduct(procuctCode),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(defaultValue = "productCode") String sortBy){
        return new ResponseEntity<>(productService.getAllProducts(pageNo,pageSize,sortBy),HttpStatus.OK);

    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "productCode") String procuctCode){
        productService.deleteProduct(procuctCode);
        return new ResponseEntity("Product Deleted Successfully",HttpStatus.OK);
    }
}
