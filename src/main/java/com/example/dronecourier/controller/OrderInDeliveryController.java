package com.example.dronecourier.controller;

import com.example.dronecourier.service.OrderInDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odred_in_delivery")
@RequiredArgsConstructor
public class OrderInDeliveryController {
    private final OrderInDeliveryService orderInDeliveryService;
}
