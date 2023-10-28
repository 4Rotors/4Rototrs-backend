package com.example.dronecourier.service;

import com.example.dronecourier.entity.dto.EmployeeDto;
import com.example.dronecourier.entity.mapper.EmployeeMapper;
import com.example.dronecourier.entity.model.Employee;
import com.example.dronecourier.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    private final PasswordEncoder encoder;

    public List<EmployeeDto> findAll() {
        return employeeMapper.toDto(employeeRepository.findAll());
    }

    public Optional<EmployeeDto> findOne(Long id) {
        return Optional.ofNullable(employeeMapper.toDto(employeeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("An employee with this ID was not found: " + id))));
    }

    public Employee save(EmployeeDto employeeDTO) {
        Employee employee = employeeMapper.toEntity(employeeDTO);
        employee.setPassword(encoder.encode(employeeDTO.getPassword()));
        employeeRepository.save(employee);
        return employee;
    }

    public EmployeeDto updateEmployee(EmployeeDto employee) {
        return employeeRepository
                .findById(employee.getId())
                .map(existingEvent -> {
                    employeeMapper.partialUpdate(existingEvent, employee);

                    return existingEvent;
                })
                .map(employeeRepository::save)
                .map(employeeMapper::toDto).orElseThrow(
                        EntityNotFoundException::new);
    }

    public void deleteEmployee(Long id) {
        employeeRepository
                .findById(id)
                .ifPresent(employeeRepository::delete);
    }

    public Optional<Employee> findOne(String username) {
        return employeeRepository.findByLogin(username);
    }
}
