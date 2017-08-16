package com.tw.shoppingapp.entities;

import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }
}
