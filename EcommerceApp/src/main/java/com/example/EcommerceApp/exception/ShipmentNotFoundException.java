package com.example.EcommerceApp.exception;

public class ShipmentNotFoundException extends RuntimeException{
    public ShipmentNotFoundException(String message){
        super(message);
    }
}
