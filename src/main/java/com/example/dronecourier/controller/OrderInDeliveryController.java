package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.OrderInDeliveryDto;
import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.dto.TrackNumberDto;
import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.entity.model.Order;
import com.example.dronecourier.entity.model.OrderItem;
import com.example.dronecourier.service.OrderInDeliveryService;
import com.example.dronecourier.service.OrderItemService;
import com.example.dronecourier.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/order_in_delivery")
@RequiredArgsConstructor
@CrossOrigin
public class OrderInDeliveryController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @PostMapping("/location")
    public PointDto getLocation(@RequestBody TrackNumberDto trackNumberDto) {
        if (trackNumberDto.getTrackNumber().equals("111")) {
            List<PointDto> points = new ArrayList<>(
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
            int rnd = new Random().nextInt(points.size());
            return points.get(rnd);
        }
        return new PointDto(1d, 1d);
    }

    @GetMapping("/drone/{id}")
    public OrderInDeliveryDto calculateDrone(@PathVariable("id")  Long id){ // { "id": 1 }
        Order order = orderService.getOrder(id);
        List<OrderItem> items = orderItemService.getItemsByOrder(order);
        //List<Drone>
        return null;
    }
}
