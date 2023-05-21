package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.Customer;
import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.exception.OrderNotFoundException;
import com.example.EcommerceApp.repository.OrderRepo;
import com.example.EcommerceApp.repository.ProductRepo;
import com.example.EcommerceApp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    @Override
    public Order createOrder(Customer customer, Long productId, int quantity) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setShipped(false);
        order.setDelivered(false);

        Product product = productRepo.findById(productId).get();
        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);

        order.setOrderItem(Collections.singletonList(orderItem));

        return orderRepo.save(order);
    }

    @Override
    public Order findOrderById(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order is not found"));
        return order;
    }

    @Override
    public void updateOrderShippedStatus(Long orderId, boolean shipped) {
        Order order = findOrderById(orderId);
        order.setShipped(shipped);
        orderRepo.save(order);
    }

    @Override
    public void confirmOrderDelivery(Long orderId) {
        Order order = findOrderById(orderId);
        order.setDelivered(true);
        orderRepo.save(order);
    }

    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}
