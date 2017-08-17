package com.tw.shoppingapp.controller;

import com.tw.shoppingapp.entity.Category;
import com.tw.shoppingapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "/category", produces = APPLICATION_JSON_VALUE)
    public List<Category> getCategory() {
        return categoryService.getCategories();
    }
}
