package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.model.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel addProduct(ProductModel  productModel);
    ProductModel updateProduct(ProductModel  productModel);
    Product getProductById(Long productId);

    List<ProductModel> getAllProducts();

    void activateProduct(Long productId);

    void deactivateProduct(Long productId);
    List<Product> findByActiveTrue();

    List<Product> findByProductCategoryId(Long categoryId);

    List<Product> findByProductCategoryAndPriceRange(Long categoryId,
                                                            Double minPrice,
                                                            Double maxPrice);
    void deleteProduct(Long productId);
}
