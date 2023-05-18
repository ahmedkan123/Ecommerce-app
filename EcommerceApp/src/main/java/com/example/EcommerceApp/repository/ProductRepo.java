package com.example.EcommerceApp.repository;


import com.example.EcommerceApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByActiveTrue();
    @Query(value = "select product from Product product join product.productCategory "
            + "category where category.categoryId = :categoryId")
    List<Product> findByProductCategoryId(Long categoryId);
    @Query(value = "select product from Product product join product.productCategory"
            + " category where category.categoryId = :categoryId"
            + " and product.price >= :minPrice and product.price <= :maxPrice")
    List<Product> findByProductCategoryAndPriceRange(Long categoryId,Double minPrice, Double maxPrice);


}
