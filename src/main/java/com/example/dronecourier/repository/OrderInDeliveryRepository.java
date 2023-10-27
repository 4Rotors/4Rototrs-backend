package com.example.dronecourier.repository;

import com.example.dronecourier.entity.model.OrderInDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInDeliveryRepository extends JpaRepository<OrderInDelivery, Long> {
}
