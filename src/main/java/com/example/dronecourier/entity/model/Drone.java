package com.example.dronecourier.entity.model;

import com.example.dronecourier.entity.model.enums.DroneStatus;
import com.example.dronecourier.entity.model.enums.DroneType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "drones")
@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "charge")
    private Integer charge;


    @Column(name = "capacity")
    private Integer capacity;


    @Column(name = "distance")
    private Integer distance;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private DroneType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private DroneStatus status;

    @Column(name = "image")
    private byte[] image;
}
