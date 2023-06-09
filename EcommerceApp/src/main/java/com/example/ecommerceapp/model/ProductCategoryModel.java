package com.example.ecommerceapp.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductCategoryModel {
    @NotNull(message = "category name is not null")
    @NotEmpty(message = "should be category name are known")
    private String categoryName;
}
