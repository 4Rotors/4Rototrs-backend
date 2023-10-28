package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class OrderCompleteDto {
    private Long droneId;
    private Long orderId;
}
