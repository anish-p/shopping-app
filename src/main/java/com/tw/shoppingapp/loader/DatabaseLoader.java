package com.tw.shoppingapp.loader;

import com.tw.shoppingapp.entity.Category;
import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.CategoryRepository;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public DatabaseLoader(ProductRepository repository, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Category mobiles = categoryRepository.save(new Category("Mobiles"));
        IntStream.range(1, 10).forEach(counter -> repository.save(new Product("Phone " + counter, "Android Smartphone", 300.2D + counter * 10, "https://s3.amazonaws.com/phoneradar/images/touchscreenico.jpg", counter, mobiles)));

        Category electronics = categoryRepository.save(new Category("Electronics"));
        IntStream.range(1, 10).forEach(counter -> repository.save(new Product("Camera " + counter, "Digital Camera", 150D + counter * 1.2, "https://s3.amazonaws.com/phoneradar/images/cameraico.jpg", counter, electronics)));

        Category apparels = categoryRepository.save(new Category("Apparels"));
        IntStream.range(1, 10).forEach(counter -> repository.save(new Product("Shirt " + counter, "Silk Shirt", 19.99D + counter * 1.8, "https://s3.amazonaws.com/phoneradar/images/cameraico.jpg", counter, apparels)));

        Category household = categoryRepository.save(new Category("Household"));
        IntStream.range(1, 10).forEach(counter -> repository.save(new Product("Sofa " + counter, "Italian Sofa", 219.99D + counter * 12, "https://s3.amazonaws.com/phoneradar/images/cameraico.jpg", counter, household)));
    }
}