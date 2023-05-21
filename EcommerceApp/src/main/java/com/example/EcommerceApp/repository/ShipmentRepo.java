package com.example.EcommerceApp.repository;

import com.example.EcommerceApp.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepo extends JpaRepository<Shipment, Long> {
}
