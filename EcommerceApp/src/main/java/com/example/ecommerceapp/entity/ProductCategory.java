package com.example.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "product-category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    private boolean active;
}