package com.example.dronecourier.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(description = "Login и Password")
public class AuthDto {

    @Schema(description = "login")
    private String login;

    @Schema(description = "password")
    private String password;
}
