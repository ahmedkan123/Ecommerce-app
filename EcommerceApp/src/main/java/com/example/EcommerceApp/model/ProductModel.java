package com.example.EcommerceApp.model;

import com.example.EcommerceApp.entity.ProductCategory;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class ProductModel {
    private Long productId;
    @NotNull(message = "product can not null value")
    @NotEmpty(message = "should be enter product name")
    private String productName;
    @Size(max = 1000, message = "Product description must be no more than " +
            "1000 characters")
    private String description;
    @NotNull(message = "Product price is required")
    @Positive(message = "Product price must be greater than zero")
    private double price;
    @Positive(message = "Product quantity must be greater than or equal zero")
    private Long quantity;
    private boolean active;
    private ProductCategory productCategory;

}
