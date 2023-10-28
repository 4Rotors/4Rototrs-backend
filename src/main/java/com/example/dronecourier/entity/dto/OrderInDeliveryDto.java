package com.example.dronecourier.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInDeliveryDto {
    private String trackNumber;
    private Long droneId;
    private String droneName;
}
