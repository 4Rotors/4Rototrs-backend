package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private String name;
    private Integer count;
    private Double price;
    private Integer weight;
}
