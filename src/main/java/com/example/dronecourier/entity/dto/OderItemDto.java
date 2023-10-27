package com.example.dronecourier.entity.dto;

import lombok.Data;

@Data
public class OderItemDto {
    private Long id;
    private Integer orderId;
    private String name;
    private Integer count;
    private Integer price;
    private Integer weight;
}