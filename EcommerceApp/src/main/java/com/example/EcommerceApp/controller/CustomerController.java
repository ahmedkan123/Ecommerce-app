package com.example.EcommerceApp.controller;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.service.implementation.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;
    @PostMapping("")
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }
    @PostMapping("/{customerId}/orders")
    public Order createOrder(@PathVariable Long customerId,
                             @RequestParam Long productId,@RequestParam int quantity) {
        return customerService.createOrder(customerId, productId, quantity);
    }
    @PostMapping("/orders/{orderId}/confirm-delivery")
    public void confirmOrderDelivery(@PathVariable Long orderId) {
        customerService.confirmOrderDelivery(orderId);
    }
}
