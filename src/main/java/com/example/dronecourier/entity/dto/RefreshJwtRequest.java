package com.example.dronecourier.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "RefreshToken")
public class RefreshJwtRequest {

    @Schema(description = "refresh token")
    private String refreshToken;
}
