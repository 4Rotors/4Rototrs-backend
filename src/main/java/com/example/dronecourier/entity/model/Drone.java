package com.example.dronecourier.entity.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "drons")
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "charge")
    private Integer charge;

    @NonNull
    @Column(name = "capacity")
    private Integer capacity;

    @NonNull
    @Column(name = "distance")
    private Integer distance;

    @NonNull
    @Column(name = "type")
    private String type;

    @NonNull
    @Column(name = "status")
    private String status;
}
