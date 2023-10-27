package com.example.dronecourier.entity.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_items")
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "order_id")
    private Integer orderId;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "count")
    private Integer count;

    @NonNull
    @Column(name = "price")
    private Integer price;

    @NonNull
    @Column(name = "weight")
    private Integer weight;
}