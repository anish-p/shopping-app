package com.tw.shoppingapp.service;

import com.tw.shoppingapp.entity.Cart;
import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    ProductRepository productRepository;

    public Cart getCart(long productId) {
        Product product = productRepository.getOne(productId);
        return new Cart(new Product(product));
    }
}
