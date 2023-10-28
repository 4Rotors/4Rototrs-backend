package com.example.dronecourier.controller;

import com.example.dronecourier.controller.api.OrderInDeliveryApi;
import com.example.dronecourier.entity.dto.OrderInDeliveryDto;
import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.dto.TrackNumberDto;
import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.entity.model.enums.DroneStatus;
import com.example.dronecourier.entity.model.enums.OrderStatus;
import com.example.dronecourier.service.DroneService;
import com.example.dronecourier.service.OrderInDeliveryService;
import com.example.dronecourier.service.OrderItemService;
import com.example.dronecourier.service.OrderService;
import com.example.dronecourier.utils.DroneUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/order_in_delivery")
@RequiredArgsConstructor
@CrossOrigin
public class OrderInDeliveryController implements OrderInDeliveryApi {

    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final DroneService droneService;

    private final List<PointDto> points = new ArrayList<>(
            List.of(
                    new PointDto(51.682310, 39.192868),
                    new PointDto(51.681510, 39.191176),
                    new PointDto(51.666462, 39.191962),
                    new PointDto(51.659090, 39.195517),
                    new PointDto(51.664016, 39.203387),
                    new PointDto(51.665634, 39.205818),
                    new PointDto(51.667036, 39.207970),
                    new PointDto(51.664659, 39.196848),
                    new PointDto(51.660818, 39.202110),
                    new PointDto(51.660538, 39.204494)
            ));

    @PostMapping("/location")
    public PointDto getLocation(@RequestBody TrackNumberDto trackNumberDto) {
        int rnd = new Random().nextInt(points.size());
        return points.get(rnd);
    }

    @GetMapping("/drone/{id}")
    public OrderInDeliveryDto calculateDrone(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        List<OrderItem> items = orderItemService.getItemsByOrder(order);
        List<Drone> drones = droneService.getAll();
        PointDto startPoint = new PointDto(51.682310, 39.192868);
        int rnd = new Random().nextInt(points.size());
        PointDto endPoint = points.get(rnd == 0 ? rnd + 1 : rnd);

        Long droneId = DroneUtils.calculateDrone(drones, startPoint, endPoint, order, items);
        String trackNumber = RandomStringUtils.randomAlphabetic(10);
        Drone drone = droneService.getById(droneId);

        order.setStatus(OrderStatus.IN_WAY);
        drone.setStatus(DroneStatus.IN_DELIVERY);

        orderService.save(order);
        droneService.save(drone
        );
        return new OrderInDeliveryDto(trackNumber, droneId,  drone.getName());
    }
}
