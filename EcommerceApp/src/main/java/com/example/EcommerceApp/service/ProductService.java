package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel addProduct(ProductModel  productModel);
    ProductModel updateProduct(ProductModel  productModel);

    List<ProductModel> getAllProducts();

    void activateProduct(Long productId);

    void deactivateProduct(Long productId);
    List<Product> findByActiveTrue();

    List<Product> findByProductCategoryId(Long categoryId);

    List<Product> findByProductCategoryAndPriceRange(Long categoryId,
                                                            Double minPrice,
                                                            Double maxPrice);
}
