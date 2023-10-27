package com.example.dronecourier.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "drons")
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

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
    private Integer status;
}
