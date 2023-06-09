package com.example.ecommerceapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipments")
@Setter
@Getter
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;
    private String status;
    @OneToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
