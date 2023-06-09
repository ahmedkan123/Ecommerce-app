package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.entity.OrderItem;
import com.example.ecommerceapp.service.implementation.OrderItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemServiceImpl orderItemService;
    @GetMapping("/order")
    public List<OrderItem> getOrderItemsByOrderId(@RequestParam Long orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }
    @DeleteMapping("")
    public void deleteOrderItem(@RequestParam Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
