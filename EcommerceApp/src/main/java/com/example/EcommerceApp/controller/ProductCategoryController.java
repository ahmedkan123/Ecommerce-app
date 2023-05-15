package com.example.EcommerceApp.controller;


import com.example.EcommerceApp.entity.ProductCategory;
import com.example.EcommerceApp.service.implementation.ProductCategoryServiceImpl;
import jakarta.validation.Valid;
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

    @PutMapping("/{id}/activate")
    public void activateCategory(@PathVariable(value = "id") Long categoryId) {
        productCategoryService.activateCategory(categoryId);
    }

//    @PutMapping("/{id}/deactivate")
//    public void deactivateCategory(@PathVariable(value = "id") Long categoryId) {
//        productCategoryService.deactivateCategory(categoryId);
//    }

}
