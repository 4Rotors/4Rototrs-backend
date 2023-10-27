package com.example.dronecourier.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "order_items")
@Entity
public class OrderInDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NonNull
    @Column(name = "location")
    private String location;

    @NonNull
    @Column(name = "order_id")
    private Integer orderId;

    @NonNull
    @Column(name = "dron_id")
    private Integer droneId;
}
