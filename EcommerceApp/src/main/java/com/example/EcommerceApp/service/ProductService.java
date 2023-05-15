package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    List<Product> getAllProducts();

    void activateProduct(Long productId);

    void deactivateProduct(Long productId);

    List<Product> findByProductCategoryId(Long categoryId);

    List<Product> findByProductCategoryAndPriceRange(Long categoryId,
                                                            Double minPrice,
                                                            Double maxPrice);
}
