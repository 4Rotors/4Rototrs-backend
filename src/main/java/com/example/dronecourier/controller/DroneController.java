package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.drone.DroneCreateRequestDto;
import com.example.dronecourier.entity.dto.drone.DroneResponseDto;
import com.example.dronecourier.entity.model.Drone;
import com.example.dronecourier.entity.model.enums.DroneStatus;
import com.example.dronecourier.entity.model.enums.DroneType;
import com.example.dronecourier.service.DroneService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/drones")
@RequiredArgsConstructor
public class DroneController {
    private final DroneService droneService;

    @GetMapping()
    public List<DroneResponseDto> getDrones() {
        return droneService.getAll().stream().map(this::translateToDto).toList();
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> addDrone(@RequestBody DroneCreateRequestDto dto){
        droneService.save(translateToEntity(dto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<HttpStatus> deleteDrone(@PathVariable("id") Long id){
        droneService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public DroneResponseDto getDrone(@PathVariable("id") Long id){
        return translateToDto(droneService.getById(id));
    }


    private DroneResponseDto translateToDto(Drone drone) {
        DroneResponseDto dto = new DroneResponseDto();

        dto.setId(dto.getId());
        dto.setName(dto.getName());
        dto.setStatus(drone.getStatus().getName());
        dto.setCharge(drone.getCharge());
        dto.setCapacity(drone.getCapacity());
        dto.setDistance(drone.getDistance());

        return dto;
    }

    private Drone translateToEntity(DroneCreateRequestDto dto){
        Drone drone = new Drone();

        if(dto.getType().equals(DroneType.GROUND.getName()) || dto.getType().equals(DroneType.AIR.getName())){
            throw new RuntimeException("Некоректный тип");
        }

        drone.setName(dto.getName());
        drone.setCapacity(dto.getCapacity());
        drone.setCharge(100);
        drone.setStatus(DroneStatus.READY);
        drone.setDistance(dto.getDistance());
        drone.setType(dto.getType().equals(DroneType.AIR.getName()) ? DroneType.AIR : DroneType.GROUND);

        return drone;
    }
}
