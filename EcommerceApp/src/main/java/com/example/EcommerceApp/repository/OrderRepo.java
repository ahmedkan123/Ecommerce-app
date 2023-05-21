package com.example.EcommerceApp.repository;

import com.example.EcommerceApp.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query(value = "select order from Order order join order.customer "
            + "customer where customer.customerId = :customerId")
    List<Order> findByCustomerId(Long customerId);
}
