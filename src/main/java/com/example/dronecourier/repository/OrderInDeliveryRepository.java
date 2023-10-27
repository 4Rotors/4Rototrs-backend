package com.example.dronecourier.repository;

import com.example.dronecourier.model.OrderInDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInDeliveryRepository extends JpaRepository<OrderInDelivery, Integer> {
}
