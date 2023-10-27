package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class DroneDto {
    private Long id;
    private String name;
    private Integer charge;
    private Integer capacity;
    private Integer distance;
    private String type;
    private Integer status;
}
