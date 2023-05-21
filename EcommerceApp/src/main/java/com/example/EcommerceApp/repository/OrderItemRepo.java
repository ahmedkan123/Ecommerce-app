package com.example.EcommerceApp.repository;

import com.example.EcommerceApp.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {
    @Query(value = "select orderItem from OrderItem orderItem join orderItem.order "
            + "order where order.orderId = :orderId")
    List<OrderItem> findByOrderId(Long orderId);
}
