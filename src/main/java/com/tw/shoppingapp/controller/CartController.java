package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.entity.Cart;
import com.tw.shoppingapp.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping(value = "/carts", produces = APPLICATION_JSON_VALUE)
    public Cart getCart(@RequestParam long productId) {
        return cartService.getCart(productId);
    }
}
