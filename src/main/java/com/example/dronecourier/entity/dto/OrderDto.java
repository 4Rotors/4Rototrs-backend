package com.example.dronecourier.entity.dto;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDto {
    private Long id;
    private String deliveryAddress;
    private String status;
    private Date arrivalDate;
}
