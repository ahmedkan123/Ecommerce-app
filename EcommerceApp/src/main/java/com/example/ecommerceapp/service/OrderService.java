package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.model.OrderItemModel;

import java.util.List;

public interface OrderService {
    Order createOrder(Customer customer, List<OrderItemModel> orderItemModels);
    Order findOrderById(Long orderId);
    void updateOrderShippedStatus(Long orderId, boolean shipped);
    void confirmOrderDelivery(Long orderId);
    List<Order> findOrdersByCustomerId(Long customerId);

}
