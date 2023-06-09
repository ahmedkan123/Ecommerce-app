package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.model.OrderItemModel;
import com.example.ecommerceapp.service.implementation.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderServiceImpl orderService;
    @PostMapping
    public Order createOrder(@RequestBody CreateRequest request) {
        List<OrderItemModel> orderItemModels = request.getOrderItemModels();
        Customer customer = request.getCustomer();
        return orderService.createOrder(customer,orderItemModels);
    }
    @GetMapping("/{id}")
    public Order findOrderById(@PathVariable(value = "id") Long orderId) {
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
    @GetMapping("")
    public List<Order> findOrdersByCustomerId(@RequestParam Long customerId) {
        return orderService.findOrdersByCustomerId(customerId);
    }

}
