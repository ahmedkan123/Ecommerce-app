package com.example.ecommerceapp.service.implementation;

import com.example.ecommerceapp.entity.Customer;
import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.entity.OrderItem;
import com.example.ecommerceapp.exception.OrderNotFoundException;
import com.example.ecommerceapp.model.OrderItemModel;
import com.example.ecommerceapp.repository.OrderRepo;
import com.example.ecommerceapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderItemServiceImpl orderItemService;

    @Override
    public Order createOrder(Customer customer, List<OrderItemModel> orderItemModels) {
        Order order = new Order();
        order.setCustomer(customer);
        order.setShipped(false);
        order.setDelivered(false);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderStatus("pending");

        List<OrderItem> orderItems = orderItemService
                .createOrderItems(order, orderItemModels);
        order.setOrderItem(orderItems);

        return orderRepo.save(order);
    }

    @Override
    public Order findOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order is not found"));
    }

    @Override
    public void updateOrderShippedStatus(Long orderId, boolean shipped) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order is not found"));
        order.setShipped(shipped);
        orderRepo.save(order);
    }

    @Override
    public void confirmOrderDelivery(Long orderId) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order is not found"));
        order.setDelivered(true);
        orderRepo.save(order);
    }

    @Override
    public List<Order> findOrdersByCustomerId(Long customerId) {
        return orderRepo.findByCustomerId(customerId);
    }
}
