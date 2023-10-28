package com.example.dronecourier.service;

import com.example.dronecourier.entity.dto.AuthDto;
import com.example.dronecourier.entity.dto.EmployeeDto;
import com.example.dronecourier.entity.dto.JwtResponse;
import com.example.dronecourier.entity.model.Employee;
import com.example.dronecourier.security.JwtCore;
import io.jsonwebtoken.Claims;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthService {

    private final JwtCore jwtCore;
    private final AuthenticationManager authenticationManager;
    private final EmployeeService employeeService;


    public JwtResponse registration(EmployeeDto employeeDTO){
        Employee employee = employeeService.save(employeeDTO);
        String accessToken = jwtCore.generateAccessToken(employee);
        String refreshToken = jwtCore.generateRefreshToken(employee);
        return new JwtResponse(accessToken,refreshToken);
    }

    public JwtResponse login(AuthDto authDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authDto.getLogin(),authDto.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            // exception
        }
        final Employee employee = employeeService.findOne(authDto.getLogin()).orElseThrow();
        final String accessToken = jwtCore.generateAccessToken(employee);
        final String refreshToken = jwtCore.generateRefreshToken(employee);
        return new JwtResponse(accessToken,refreshToken);
    }

    public JwtResponse getAccessToken(String refreshToken) {
        return generateAccessTokenOrRefresh(refreshToken,"getAccessToken");
    }

    public JwtResponse refresh(String refreshToken){
        return generateAccessTokenOrRefresh(refreshToken,"refresh");
    }

    private JwtResponse generateAccessTokenOrRefresh(String refreshToken, String action) {
        if(jwtCore.validateRefreshToken(refreshToken)){
            final Claims claims = jwtCore.extractRefreshClaims(refreshToken);
            final String username = claims.getSubject();
            final Integer id = (Integer) claims.get("employee_id");
            Optional<EmployeeDto> employeeFromDb = employeeService.findOne(Long.valueOf(id));

            if(employeeFromDb.isEmpty()){
                throw new EntityNotFoundException("An employee with this ID has been removed");
            }
            Employee employeeForJwt = new Employee();
            employeeForJwt.setLogin(username);
            employeeForJwt.setId(Long.valueOf(id));
            final String accessToken = jwtCore.generateAccessToken(employeeForJwt);
            if (action.equals("refresh")){
                final String newRefreshToken = jwtCore.generateRefreshToken(employeeForJwt);
                return new JwtResponse(accessToken,newRefreshToken);
            } else {
                return new JwtResponse(accessToken,null);
            }
        }
        return new JwtResponse(null,null);
    }
}
