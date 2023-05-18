package com.example.EcommerceApp.repository;

import com.example.EcommerceApp.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByActiveTrue();
}
