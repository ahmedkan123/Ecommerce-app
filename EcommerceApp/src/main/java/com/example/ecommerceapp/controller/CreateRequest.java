package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.model.OrderItemModel;
import lombok.Data;

import java.util.List;
@Data
public class CreateRequest {
    private Customer customer;
    private List<OrderItemModel> orderItemModels;

}
