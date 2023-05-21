package com.example.EcommerceApp.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "Product_name")
    private String productName;
    private String description;
    private double price;
    private boolean active;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private ProductCategory productCategory;


}
