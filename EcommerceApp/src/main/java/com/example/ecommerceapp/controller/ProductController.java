package com.example.ecommerceapp.controller;


import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.model.ProductModel;
import com.example.ecommerceapp.service.implementation.ProductServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;

    @PostMapping
    public ProductModel addProduct(@Valid @RequestBody ProductModel productModel) {
        return productService.addProduct(productModel);
    }

    @PutMapping
    public ProductModel updateProduct(@Valid @RequestBody ProductModel productModel) {
        return productService.updateProduct(productModel);
    }

    @GetMapping
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
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable(value = "id") Long productId) {
        productService.deleteProduct(productId);
    }
}
