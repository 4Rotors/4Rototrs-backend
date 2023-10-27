package com.example.dronecourier.service;

import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public List<Order> getAll(){
        return orderRepository.findAll();
    }

    public Order getOrder(Long id){
        return orderRepository.findById(id).orElse(null);
    }

    @Transactional
    public Long save(Order order){
        return orderRepository.save(order).getId();
    }

    @Transactional
    public void delete(Long id){
        orderRepository.deleteById(id);
    }

}
