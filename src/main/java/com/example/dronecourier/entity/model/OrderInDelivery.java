package com.example.dronecourier.entity.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "order_items")
@Entity
public class OrderInDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name = "order_id")
    private Long orderId;

    @NonNull
    @Column(name = "dron_id")
    private Long droneId;
}
