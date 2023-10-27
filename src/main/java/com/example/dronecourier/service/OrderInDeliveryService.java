package com.example.dronecourier.service;

import com.example.dronecourier.repository.OrderInDeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderInDeliveryService {
    private final OrderInDeliveryRepository orderInDeliveryRepository;
}
