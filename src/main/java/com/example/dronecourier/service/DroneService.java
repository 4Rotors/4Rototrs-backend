package com.example.dronecourier.service;

import com.example.dronecourier.repository.DroneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final DroneRepository droneRepository;
}
