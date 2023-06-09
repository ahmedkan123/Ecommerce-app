package com.example.ecommerceapp.repository;

import com.example.ecommerceapp.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepo extends JpaRepository<Shipment, Long> {
}
