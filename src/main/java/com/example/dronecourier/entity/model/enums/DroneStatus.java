package com.example.dronecourier.entity.model.enums;

public enum DroneStatus {
    READY("Готов к вылету"),
    IN_DELIVERY("На доставке"),
    ON_CHARGE("На зарядке");

    private final String name;

    DroneStatus(String status){
        this.name = status;
    }

    public String getName() {
        return name;
    }
}
