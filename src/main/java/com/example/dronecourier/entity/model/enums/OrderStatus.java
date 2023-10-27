package com.example.dronecourier.entity.model.enums;

public enum OrderStatus {
    GOING("Собирается"),
    IN_WAY("В пути"),
    DELIVERED("Доставлен");

    private final String name;

    OrderStatus(String status) {
        this.name = status;
    }

    public String getName() {
        return name;
    }
}
