package com.example.dronecourier.utils;

import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.entity.model.enums.DroneStatus;
import com.example.dronecourier.entity.model.enums.OrderStatus;

import java.util.List;

public class DroneUtils {

    public static Long calculateDrone(List<Drone> droneList, double startX, double startY,
                                      double endX, double endY, Order order, List<OrderItem> orderItems) {
        if (order.getStatus() != OrderStatus.GOING) {
            return -1L;
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
        return -1L;
    }

}