package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.entity.OrderItem;
import com.example.ecommerceapp.model.OrderItemModel;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> createOrderItems(Order order
            , List<OrderItemModel> orderItemModels);
    List<OrderItem> getOrderItemsByOrderId(Long orderId);
    void deleteOrderItem(Long orderItemId);
}
