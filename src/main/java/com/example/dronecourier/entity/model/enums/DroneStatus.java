package com.example.dronecourier.entity.model.enums;

public enum DroneStatus {
    READY("готов к вылету"),
    IN_DELIVERY("на доставке"),
    ON_CHARGE("на зарядке");

    private final String name;

    DroneStatus(String status){
        this.name = status;
    }

    public String getName() {
        return name;
    }
}
