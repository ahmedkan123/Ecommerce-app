package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory addCategory(ProductCategory productCategory);
    ProductCategory updateCategory(ProductCategory category);
    void activateCategory(Long categoryId);
    List<ProductCategory> getAllCategories();
    List<ProductCategory> findByActiveTrue();


}
