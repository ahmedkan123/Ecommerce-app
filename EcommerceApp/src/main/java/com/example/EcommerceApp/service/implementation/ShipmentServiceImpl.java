package com.example.EcommerceApp.service.implementation;

import com.example.EcommerceApp.entity.Order;
import com.example.EcommerceApp.entity.Shipment;
import com.example.EcommerceApp.exception.ShipmentNotFoundException;
import com.example.EcommerceApp.repository.ShipmentRepo;
import com.example.EcommerceApp.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {
    private final ShipmentRepo shipmentRepo;
    @Override
    public Shipment createShipment(Order order) {
        Shipment shipment = new Shipment();
        shipment.setOrder(order);
        return shipmentRepo.save(shipment);
    }

    @Override
    public Shipment updateShipmentStatus(Long shipmentId, String status) {
        Shipment shipment = getShipmentById(shipmentId);
        shipment.setStatus(status);
        return shipmentRepo.save(shipment);
    }

    @Override
    public Shipment getShipmentById(Long shipmentId) {
        return shipmentRepo.findById(shipmentId)
                .orElseThrow(() -> new ShipmentNotFoundException("Shipment not found"));
    }
}
