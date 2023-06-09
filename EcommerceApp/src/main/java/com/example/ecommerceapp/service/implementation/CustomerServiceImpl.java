package com.example.ecommerceapp.service.implementation;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.exception.CustomerNotFoundException;
import com.example.ecommerceapp.repository.CustomerRepo;
import com.example.ecommerceapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }

}
