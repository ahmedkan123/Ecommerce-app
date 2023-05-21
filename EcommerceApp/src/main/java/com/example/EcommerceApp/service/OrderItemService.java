package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.entity.Product;

import java.util.List;

public interface OrderItemService {
    OrderItem createOrderItem(Product product, int quantity);
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    void deleteOrderItem(Long orderItemId);
}
