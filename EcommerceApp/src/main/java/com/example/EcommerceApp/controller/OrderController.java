package com.example.EcommerceApp.controller;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.service.implementation.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;
    @PostMapping("")
    public Order createOrder(@RequestBody Customer customer
            , @RequestParam Long productId,@RequestParam int quantity) {
        return orderService.createOrder(customer, productId, quantity);
    }
    @GetMapping("/{orderId}")
    public Order findOrderById(@PathVariable Long orderId) {
        return orderService.findOrderById(orderId);
    }
    @PutMapping("/{orderId}/shipped")
    public void updateOrderShippedStatus(@PathVariable Long orderId
            ,@RequestParam boolean shipped) {
        orderService.updateOrderShippedStatus(orderId, shipped);
    }
    @PutMapping("/{orderId}/confirmed")
    public void confirmOrderDelivery(@PathVariable Long orderId) {
        orderService.confirmOrderDelivery(orderId);

    }
    @GetMapping("/{customerId}")
    public List<Order> findOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

}
