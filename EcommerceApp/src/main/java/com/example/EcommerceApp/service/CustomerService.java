package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;

import java.util.List;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long customerId);
    Order createOrder(Long customerId, Long productId, int quantity);
    void confirmOrderDelivery(Long orderId);

}
