package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.service.implementation.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }

}
