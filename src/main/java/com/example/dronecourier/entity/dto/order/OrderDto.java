package com.example.dronecourier.entity.dto.order;

import com.example.dronecourier.entity.dto.OrderItemDto;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String deliveryAddress;
    private String arrivalDate;
    private List<OrderItemDto> items;
}
