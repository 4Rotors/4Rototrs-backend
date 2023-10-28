package com.example.dronecourier.controller.api;

import com.example.dronecourier.entity.dto.order.OrderDto;
import com.example.dronecourier.entity.dto.order.OrderDtoResponse;
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

@Tag(name = "Order Api", description = "Api для работы с заказми")
public interface OrderApi {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное добавление заказа",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OrderDto.class)
                            )
                    }
            )
    })
    @Operation(summary = "Добавление заказа")
    ResponseEntity<HttpStatus> addOrder(
            @Parameter(description = "Данные заказа")
            OrderDto orderDto
    );

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение списка заказов",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = OrderDto.class)
                            )
                    }
            )
    })
    @Operation(summary = "Получение списка заказов")
    List<OrderDtoResponse> getAll();

}
