package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class OrderInDeliveryDto {
    private Long id;
    private String location;
    private Long orderId;
    private Long droneId;
}
