package com.example.ecommerceapp.repository;

import com.example.ecommerceapp.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByActiveTrue();
}
