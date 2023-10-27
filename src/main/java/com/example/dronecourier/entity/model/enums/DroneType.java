package com.example.dronecourier.entity.model.enums;

public enum DroneType {
    GROUND("Наземный"),
    AIR("Воздушный");


    private final String name;

    DroneType(String type) {
        this.name = type;
    }

    public String getName(){
        return name;
    }






}
