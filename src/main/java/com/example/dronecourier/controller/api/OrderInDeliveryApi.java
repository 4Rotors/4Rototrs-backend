package com.example.dronecourier.controller.api;

import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.dto.TrackNumberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Order in delivery Api", description = "Api для получения информации о доставке")
public interface OrderInDeliveryApi {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение локации дрона",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = PointDto.class)
                            )
                    }
            ),
    })

    @Operation(summary = "Возвращает точку на карте")
    PointDto getLocation(
            @Parameter(description = "Трек-номер")
            TrackNumberDto trackNumberDto);
}
