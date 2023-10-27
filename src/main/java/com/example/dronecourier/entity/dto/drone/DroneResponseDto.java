package com.example.dronecourier.entity.dto.drone;

import lombok.Data;

@Data
public class DroneResponseDto {
    private Long id;

    private String name;

    private Integer charge;

    private Integer capacity;

    private Integer distance;

    private String type;

    private String status;
}
