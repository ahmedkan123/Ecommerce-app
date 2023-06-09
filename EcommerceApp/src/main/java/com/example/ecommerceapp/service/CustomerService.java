package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer getCustomerById(Long customerId);

}
