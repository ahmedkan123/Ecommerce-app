package com.example.EcommerceApp.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductCategoryModel {
    private Long categoryId;

    private String categoryName;
}
