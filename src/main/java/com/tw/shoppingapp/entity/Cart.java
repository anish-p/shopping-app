package com.tw.shoppingapp.entity;

import java.io.Serializable;
import java.util.List;

public class Cart implements Serializable {

    private long id;
    private List<Product> products;
    private double amount;
    private double tax;
    private double total;

    public Cart() {
    }

}
