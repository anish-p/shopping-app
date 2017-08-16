package com.tw.shoppingapp.service;

import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Product persistedproduct = productRepository.getOne(product.getId());
        if (persistedproduct == null) {
            throw new EntityNotFoundException("Product does not exists: " + product);
        }
        persistedproduct.update(product);
        return productRepository.save(persistedproduct);
    }

    public void deleteProduct(long id) {
        Product persistedproduct = productRepository.getOne(id);
        if (persistedproduct == null) {
            throw new EntityNotFoundException("Product does not exists: " + id);
        }
        productRepository.delete(persistedproduct);
    }
}
