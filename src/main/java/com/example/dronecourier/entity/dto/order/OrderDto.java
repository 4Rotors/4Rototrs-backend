package com.example.dronecourier.entity.dto.order;

import com.example.dronecourier.entity.model.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private String deliveryAddress;
    private String arrivalDate;
    private List<OrderItem> items;
}
