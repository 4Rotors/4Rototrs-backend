package com.example.dronecourier.entity.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @NonNull
    @Column(name = "address_delivery")
    private String deliveryAddress;

    @NonNull
    @Column(name = "status")
    private String status;

    @NonNull
    @Column(name = "arrival_date")
    private Date arrivalDate;
}
