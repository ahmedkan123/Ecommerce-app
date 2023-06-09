package com.example.ecommerceapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "customers")
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    @NotNull(message = "don't the name are null")
    @NotEmpty(message = "should be enter the name please")
    private String name;
    @NotEmpty(message = "should be enter the mobile number please")
    private String mobileNumber;

}
