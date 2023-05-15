package com.example.EcommerceApp.model;

import com.example.EcommerceApp.entity.ProductCategory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductModel {

    @NotNull(message = "product can not null value")
    @NotEmpty(message = "should be enter product name")
    private String productName;
    private String description;
    @Max(value = 30000)
    @Min(value = 100)
    private double price;

}
