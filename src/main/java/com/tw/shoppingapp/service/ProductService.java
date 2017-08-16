package com.tw.shoppingapp.service;

import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    private int DEFAULT_PAGE_SIZE = 5;

    public Page<Product> getProducts(int pageNumber) {
        return productRepository.findAll(PageRequest.of(pageNumber, DEFAULT_PAGE_SIZE));
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

    public Page<Product> getProductsByCategory(int pageNumber, long categoryId) {
        return productRepository.findByCategoryId(PageRequest.of(pageNumber, DEFAULT_PAGE_SIZE), categoryId);
    }
}
