package com.example.ecommerceapp.model;

import com.example.ecommerceapp.entity.Product;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItemModel {
    private Product product;
    @Positive(message = "Product quantity must be greater than or equal zero")
    private int quantity;
}
