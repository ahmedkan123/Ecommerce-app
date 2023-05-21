package com.example.EcommerceApp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private boolean shipped;
    private boolean delivered;
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;
    @OneToMany(mappedBy = "order")
    List<OrderItem> orderItem;
}
