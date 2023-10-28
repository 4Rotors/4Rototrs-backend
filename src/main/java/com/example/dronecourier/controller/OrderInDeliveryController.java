package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.dto.TrackNumberDto;
import com.example.dronecourier.service.OrderInDeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("api/order_in_delivery")
@RequiredArgsConstructor
public class OrderInDeliveryController {

    private final OrderInDeliveryService orderInDeliveryService;

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
}
