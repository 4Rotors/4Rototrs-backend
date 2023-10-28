package com.example.dronecourier.controller;

import com.example.dronecourier.entity.dto.AuthDto;
import com.example.dronecourier.entity.dto.EmployeeDto;
import com.example.dronecourier.entity.dto.JwtResponse;
import com.example.dronecourier.entity.dto.RefreshJwtRequest;
import com.example.dronecourier.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public JwtResponse registration(@RequestBody EmployeeDto employeeDTO){
        return authService.registration(employeeDTO);
    }

    @PostMapping("/signIn")
    public JwtResponse login(@RequestBody AuthDto authDto){
        return authService.login(authDto);
    }

    @PostMapping("/accessToken")
    public JwtResponse getAccessToken(@RequestBody RefreshJwtRequest refreshJwtRequest){
        return authService.getAccessToken(refreshJwtRequest.getRefreshToken());
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@RequestBody RefreshJwtRequest refreshJwtRequest){
        return authService.refresh(refreshJwtRequest.getRefreshToken());
    }
}