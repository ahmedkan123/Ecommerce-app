package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.OrderItem;

import java.util.List;

public interface OrderService {
    Order createOrder(Customer customer, Long productId, int quantity);
    Order findOrderById(Long orderId);
    void updateOrderShippedStatus(Long orderId, boolean shipped);
    void confirmOrderDelivery(Long orderId);
    List<Order> findOrdersByCustomerId(Long customerId);

}
