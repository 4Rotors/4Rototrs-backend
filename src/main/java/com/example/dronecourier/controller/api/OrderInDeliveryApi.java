package com.example.dronecourier.controller.api;

import com.example.dronecourier.entity.dto.OrderCompleteDto;
import com.example.dronecourier.entity.dto.OrderInDeliveryDto;
import com.example.dronecourier.entity.dto.PointDto;
import com.example.dronecourier.entity.dto.TrackNumberDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение дрона с генерацией трек-номера для текущего заказа",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OrderInDeliveryDto.class)
                            )
                    }
            ),
    })

    @Operation(summary = "Возвращает дрон и трек-номер")
    OrderInDeliveryDto getDroneForOrder(@Parameter(description = "ID заказа") Long id);


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное завершение заказа"
            )
    })

    @Operation(summary = "Переводит статус заказа в 'Доставлен'")
    ResponseEntity<HttpStatus> completeOrder(@Parameter(description = "Информация о текущей досатвке")
                                             OrderCompleteDto id);
}
