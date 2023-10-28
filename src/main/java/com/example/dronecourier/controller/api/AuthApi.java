package com.example.dronecourier.controller.api;

import com.example.dronecourier.entity.dto.AuthDto;
import com.example.dronecourier.entity.dto.EmployeeDto;
import com.example.dronecourier.entity.dto.JwtResponse;
import com.example.dronecourier.entity.dto.RefreshJwtRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Auth API", description = "API для входа в систему")
public interface AuthApi {

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешный вход в аккаунт",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            ),
    })
    @Operation(summary = "Возвращает jwt и refresh токены")
    JwtResponse login(
            @Parameter(description = "Логин и пароль")
            AuthDto authDto
    );


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешная регистрация аккаунта",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Возвращает jwt и refresh токены")
    JwtResponse registration(@RequestBody EmployeeDto employeeDTO);


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешное получение accessTocken`а",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Возвращает accessToken и refreshToken = null")
    JwtResponse getAccessToken(@RequestBody RefreshJwtRequest refreshJwtRequest);

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Успешный refresh",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = JwtResponse.class)
                            )
                    }
            )
    })
    @Operation(summary = "Возвращает обновленные jwt и refresh токены")
    JwtResponse refresh(@RequestBody RefreshJwtRequest refreshJwtRequest);

}
