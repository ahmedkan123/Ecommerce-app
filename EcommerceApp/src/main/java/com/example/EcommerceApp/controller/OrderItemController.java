package com.example.EcommerceApp.controller;

import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.service.implementation.OrderItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-items")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemServiceImpl orderItemService;
    @PostMapping("")
    public OrderItem createOrderItem(@RequestBody Product product,@RequestParam int quantity) {
        return orderItemService.createOrderItem(product, quantity);
    }
    @GetMapping("/order/{orderId}")
    public List<OrderItem> getOrderItemsByOrderId(@PathVariable Long orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }
    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
