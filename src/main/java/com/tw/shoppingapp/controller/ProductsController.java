package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products", produces = APPLICATION_JSON_VALUE)
    public Page<Product> getProducts(@RequestParam(defaultValue = "0", required = false) int pageNumber, @RequestParam(required = false) Long categoryId) {
        return categoryId == null ? productService.getProducts(pageNumber) : productService.getProductsByCategory(pageNumber, categoryId);
    }

    @PostMapping(value = "/products", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Product createProducts(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping(value = "/products", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public Product updateProducts(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping(value = "/products", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public void deleteProducts(@PathVariable long id) {
        productService.deleteProduct(id);
    }
}
