package com.example.dronecourier.entity.model.enums;

public enum OrderStatus {
    GOING("собирается"),
    IN_WAY("в пути"),
    DELIVERED("доставлен");

    private final String name;

    OrderStatus(String status) {
        this.name = status;
    }

    public String getName() {
        return name;
    }
}
