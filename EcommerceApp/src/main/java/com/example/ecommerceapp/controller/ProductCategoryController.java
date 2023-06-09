package com.example.ecommerceapp.controller;


import com.example.ecommerceapp.entity.ProductCategory;
import com.example.ecommerceapp.service.implementation.ProductCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
    @Autowired
    private ProductCategoryServiceImpl productCategoryService;
    @PostMapping("")
    public ProductCategory addProductCategory(@RequestBody  ProductCategory productCategory) {
        return productCategoryService.addCategory(productCategory);
    }
    @PutMapping("")
    public ProductCategory updateCategory(@RequestBody  ProductCategory category) {
        return productCategoryService.updateCategory(category);
    }

    @GetMapping("")
    public List<ProductCategory> getAllCategories() {
        return productCategoryService.getAllCategories();
    }
    @GetMapping("/active")
    public List<ProductCategory> findActiveCategoryTrue() {
        return productCategoryService.findByActiveTrue();
    }
    @PutMapping("/{id}/activate")
    public void activateCategory(@PathVariable(value = "id") Long categoryId) {
        productCategoryService.activateCategory(categoryId);
    }


}
