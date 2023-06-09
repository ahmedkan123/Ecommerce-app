package com.example.ecommerceapp.exception;

public class ShipmentNotFoundException extends RuntimeException{
    public ShipmentNotFoundException(String message){
        super(message);
    }
}
