package com.example.dronecourier.service;

import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Transactional
    public void save(OrderItem item){
        orderItemRepository.save(item);
    }
}
