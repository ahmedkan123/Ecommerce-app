package com.example.ecommerceapp.service;

import com.example.ecommerceapp.entity.Order;
import com.example.ecommerceapp.entity.Shipment;

public interface ShipmentService {
    Shipment createShipment(Order order);
    Shipment updateShipmentStatus(Long shipmentId, String status);
    Shipment getShipmentById(Long shipmentId);
}
