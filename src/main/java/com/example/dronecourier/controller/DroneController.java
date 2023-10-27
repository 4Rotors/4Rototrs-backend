package com.example.dronecourier.controller;

import com.example.dronecourier.service.DroneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drone")
@RequiredArgsConstructor
public class DroneController {
    private final DroneService droneService;
}
