package com.example.EcommerceApp.controller;


import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.model.ProductModel;
import com.example.EcommerceApp.service.implementation.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping("")
    public ProductModel addProduct(@Valid @RequestBody ProductModel productModel) {
        return productService.addProduct(productModel);
    }

    @PutMapping("")
    public ProductModel updateProduct(@Valid @RequestBody ProductModel productModel) {
        return productService.updateProduct(productModel);
    }

    @GetMapping("")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }


    @PutMapping("/{id}/activate")
    public void activateProduct(@PathVariable(value = "id") Long productId) {
        productService.activateProduct(productId);
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateProduct(@PathVariable(value = "id") Long productId) {
        productService.deactivateProduct(productId);
    }

    @GetMapping("/active")
    public List<Product> findProductByActiveTrue() {
        return productService.findByActiveTrue();
    }

    @GetMapping("/productCategory")
    public List<Product> findByProductCategoryId(@RequestParam Long categoryId) {
        return productService.findByProductCategoryId(categoryId);
    }

    @GetMapping("/productCategory/{id}")
    public List<Product> findByProductCategoryAndPriceRange(@PathVariable(value = "id") Long categoryId
            , @RequestParam(value = "minPrice") Double minPrice
            , @RequestParam(value = "maxPrice") Double maxPrice) {
        return productService.findByProductCategoryAndPriceRange(categoryId, minPrice, maxPrice);
    }
}
