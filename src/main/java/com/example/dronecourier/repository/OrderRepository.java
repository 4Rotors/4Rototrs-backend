package com.example.dronecourier.repository;

import com.example.dronecourier.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
