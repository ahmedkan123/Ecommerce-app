package com.example.EcommerceApp.service;

import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.Shipment;

public interface ShipmentService {
    Shipment createShipment(Order order);
    Shipment updateShipmentStatus(Long shipmentId, String status);
    Shipment getShipmentById(Long shipmentId);
}
