package com.example.dronecourier.controller.api;

import com.example.dronecourier.entity.dto.drone.DroneCreateUpdateRequestDto;
import com.example.dronecourier.entity.dto.drone.DroneResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Drone Api", description = "Api для работы с дронами")
public interface DroneApi {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получения списка дронов",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DroneResponseDto.class)
                            )
                    }
            ),
    })
    @Operation(summary = "Получение списка дронов")
    List<DroneResponseDto> getDrones();


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное добавление дрона",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DroneResponseDto.class)
                            )
                    }
            ),
    })
    @Operation(summary = "Добавлние дрона")
    ResponseEntity<HttpStatus> addDrone(
            @Parameter(description = "Инфомрация о дроне")
            DroneCreateUpdateRequestDto dto);
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное удаление дрона"
            ),
    })
    @Operation(summary = "Удаление дрона")
    ResponseEntity<HttpStatus> deleteDrone(
            @Parameter(description = "Id дрона")
            Long id);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешный получкение дрона по id",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = DroneResponseDto.class)
                            )
                    }
            ),
    })
    @Operation(summary = "Поулчение дрона по id")
    DroneResponseDto getDrone(
            @Parameter(description = "Id дрона")
            Long id
    );
}
