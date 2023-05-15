package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.ProductCategory;
import com.example.EcommerceApp.repository.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductCategoryService {
    ProductCategory addCategory(ProductCategory productCategory);
    ProductCategory updateCategory(ProductCategory category);
    List<ProductCategory> getAllCategories();
    void activateCategory(Long categoryId);
//    void deactivateCategory(Long categoryId);


}
