package com.example.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private LocalDateTime orderDate;
    private String orderStatus;
    private boolean shipped;
    private boolean delivered;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<OrderItem> orderItem;
}
