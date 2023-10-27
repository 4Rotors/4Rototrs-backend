package com.example.dronecourier.controller;

import com.example.dronecourier.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order_item")
@RequiredArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;
}
