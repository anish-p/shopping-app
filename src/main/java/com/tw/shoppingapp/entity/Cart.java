package com.tw.shoppingapp.entity;

import java.io.Serializable;

public class Cart implements Serializable {

    private Product product;
    private double tax;
    private double total;

    public Cart() {
    }

    public Cart(Product product) {
        this.product = product;
        this.tax = product.getPrice()*0.18;
        this.total = this.tax + product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "product=" + product +
                ", tax=" + tax +
                ", total=" + total +
                '}';
    }
}
