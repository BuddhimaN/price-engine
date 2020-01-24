package com.retailsuper.priceengine.controller;

import com.retailsuper.priceengine.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller Class for Products
 *
 * @author BuddhimaN
 * @since 01/20
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO product) {
        return new ResponseEntity(product, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO product){
        return new ResponseEntity(product,HttpStatus.OK);
    }

    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable(name = "productCode") String procuctCode){
        return new ResponseEntity<>(new ProductDTO(),HttpStatus.OK);
    }

    @DeleteMapping("/{productCode}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name = "productCode") String procuctCode){
        return new ResponseEntity("Product Deleted Successfully",HttpStatus.OK);
    }
}
