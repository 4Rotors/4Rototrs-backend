package com.example.dronecourier.entity.model;

import com.example.dronecourier.entity.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address_delivery")
    private String deliveryAddress;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "arrival_date")
    private String arrivalDate;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;
}
