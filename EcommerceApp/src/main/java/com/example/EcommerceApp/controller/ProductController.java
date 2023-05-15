package com.example.EcommerceApp.controller;


import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.service.implementation.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @PostMapping("")
    public Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }
    @PutMapping("")
    public Product updateProduct(@RequestBody @Valid Product product) {
        return productService.updateProduct(product);
    }
    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}/activate")
    public void  activateProduct(@PathVariable(value = "id") Long productId) {
        productService.activateProduct(productId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateProduct(@PathVariable(value = "id") Long productId) {
        productService.deactivateProduct(productId);
    }
    @GetMapping("/productCategory")
    public List<Product> findByProductCategoryId(@RequestParam Long categoryId) {
        return productService.findByProductCategoryId(categoryId);
    }
    @GetMapping("/productCategory/{id}")
    public List<Product> findByProductCategoryAndPriceRange(@PathVariable(value = "id") Long categoryId
            ,@RequestParam(value = "minPrice") Double minPrice
            ,@RequestParam(value = "maxPrice") Double maxPrice) {
        return productService.findByProductCategoryAndPriceRange(categoryId,minPrice,maxPrice);
    }
}
