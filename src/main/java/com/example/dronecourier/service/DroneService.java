package com.example.dronecourier.service;

import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.repository.DroneRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DroneService {
    private final DroneRepository droneRepository;

    public List<Drone> getAll() {
        return droneRepository.findAll();
    }

    @Transactional
    public void save(Drone drone) {
        droneRepository.save(drone);
    }

    @Transactional
    public void delete(Long id){
        droneRepository.deleteById(id);
    }

    public Drone getById(Long id){
        return droneRepository.findById(id).orElse(null);
    }





}
