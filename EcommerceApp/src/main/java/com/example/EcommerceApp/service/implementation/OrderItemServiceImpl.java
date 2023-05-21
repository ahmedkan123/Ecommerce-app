package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.OrderItem;
import com.example.EcommerceApp.entity.Product;
import com.example.EcommerceApp.repository.OrderItemRepo;
import com.example.EcommerceApp.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepo orderItemRepo;
    @Override
    public OrderItem createOrderItem(Product product, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        return orderItemRepo.save(orderItem);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepo.findByOrderId(orderId);
    }

    @Override
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepo.deleteById(orderItemId);
    }
}
