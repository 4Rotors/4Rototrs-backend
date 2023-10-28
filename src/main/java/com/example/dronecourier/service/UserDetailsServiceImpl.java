package com.example.dronecourier.service;

import com.example.dronecourier.entity.model.Employee;
import com.example.dronecourier.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findByLogin(login).orElseThrow(() ->
                new EntityNotFoundException("Order not found with login: " + login));

        return new User(
                employee.getLogin(),
                employee.getPassword(),
                new ArrayList<>(Collections.singletonList(
                        new SimpleGrantedAuthority("WORKER"))));
    }
}
