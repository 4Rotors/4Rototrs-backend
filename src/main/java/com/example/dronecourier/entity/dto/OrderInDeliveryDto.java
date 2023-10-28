package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class OrderInDeliveryDto {
    private String trackNumber;
    private Long droneId;
    private String droneName;
}
