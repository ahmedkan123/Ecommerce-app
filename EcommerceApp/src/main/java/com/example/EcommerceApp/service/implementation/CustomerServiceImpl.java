package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.exception.CustomerNotFoundException;
import com.example.EcommerceApp.exception.ProductNotFoundException;
import com.example.EcommerceApp.repository.CustomerRepo;
import com.example.EcommerceApp.repository.ProductRepo;
import com.example.EcommerceApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Collections;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final OrderServiceImpl orderService;

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }
    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
    }
    @Override
    public Order createOrder(Long customerId, Long productId, int quantity) {
        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new CustomerNotFoundException("customer is not found"));
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("product is not found"));
        Order order = new Order();
        order.setCustomer(customer);

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(order);

        order.setOrderItem(Collections.singletonList(orderItem));

        return orderService.createOrder(customer,productId,quantity);
    }

    @Override
    public void confirmOrderDelivery(Long orderId) {
        orderService.confirmOrderDelivery(orderId);
    }


}
