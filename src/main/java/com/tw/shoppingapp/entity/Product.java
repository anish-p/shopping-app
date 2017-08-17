package com.tw.shoppingapp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private int availableQuantity;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, String description, double price, String imageUrl, int availableQuantity, Category category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.availableQuantity = availableQuantity;
        this.category = category;
    }

    public Product(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.availableQuantity = product.getAvailableQuantity();
        this.category = product.getCategory();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", category='" + category + '\'' +
                '}';
    }

    public void update(Product product) {
        this.name = product.name;
        this.description = product.description;
        this.price = product.price;
        this.imageUrl = product.imageUrl;
        this.availableQuantity = product.availableQuantity;
        this.category = product.category;
    }
}
