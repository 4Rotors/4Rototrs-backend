package com.example.dronecourier.entity.dto.drone;

import lombok.Data;

@Data
public class DroneCreateUpdateRequestDto {

    private String name;

    private Integer capacity;

    private Integer distance;

    private String type;
}
