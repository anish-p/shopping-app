package com.tw.shoppingapp.service;

import com.tw.shoppingapp.entity.Category;
import com.tw.shoppingapp.entity.Product;
import com.tw.shoppingapp.repository.CategoryRepository;
import com.tw.shoppingapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
