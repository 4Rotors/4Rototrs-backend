package com.example.dronecourier.utils;

import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.entity.model.enums.DroneStatus;
import com.example.dronecourier.entity.model.enums.OrderStatus;

import java.util.List;

public class DroneUtils {

    public static Long calculateDrone(List<Drone> droneList, PointDto startPoint, PointDto endPoint,
                                      Order order, List<OrderItem> orderItems) {
        double endY = endPoint.getLocationY();
        double endX = endPoint.getLocationX();
        double startY = startPoint.getLocationY();
        double startX = startPoint.getLocationX();

        if (order.getStatus() != OrderStatus.GOING) {
            return 1L;
        }
        for (Drone drone : droneList) {
            if (drone.getStatus() == DroneStatus.READY) {
                double distance = Math.sqrt((endY - startY) * (endY - startY) +
                        (endX - startX) * (endX - startX));
                if (drone.getDistance() > distance * 2) {
                    double orderMass = 0;
                    for (OrderItem orderItem : orderItems) {
                        orderMass += orderItem.getWeight();
                    }

                    if (drone.getCapacity() > orderMass) {
                        return drone.getId();
                    }
                }
            }
        }
        return 1L;
    }

}