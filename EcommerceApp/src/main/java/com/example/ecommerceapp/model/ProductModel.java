package com.example.ecommerceapp.model;

import com.example.ecommerceapp.entity.ProductCategory;
import jakarta.validation.constraints.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private boolean active;
    private ProductCategoryModel productCategory;

}
