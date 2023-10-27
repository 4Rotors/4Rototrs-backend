package com.example.dronecourier.entity.dto.drone;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DroneCreateRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private Integer capacity;
    @NotBlank
    private Integer distance;
    @NotBlank
    private String type;
}
