package com.example.ecommerceapp.service.implementation;

import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.entity.OrderItem;
import com.example.ecommerceapp.entity.Product;
import com.example.ecommerceapp.model.OrderItemModel;
import com.example.ecommerceapp.repository.OrderItemRepo;
import com.example.ecommerceapp.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepo orderItemRepo;
    private final ProductServiceImpl productService;
    @Override
    public List<OrderItem> createOrderItems(Order order
            , List<OrderItemModel> orderItemModels) {
        List<OrderItem> orderItems = new ArrayList<>();

        for (OrderItemModel orderItemModel : orderItemModels) {
            Product product = productService
                    .getProductById(orderItemModel.getProduct().getProductId());

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(orderItemModel.getQuantity());

            orderItems.add(orderItem);
        }

        return orderItems;
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
