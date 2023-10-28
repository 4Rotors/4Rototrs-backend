package com.example.dronecourier.entity.mapper;

import com.example.dronecourier.entity.dto.EmployeeDto;
import com.example.dronecourier.entity.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper extends EntityMapper<EmployeeDto, Employee> {
    EmployeeDto toDto(Employee s);

    Employee toEntity(EmployeeDto s);
}
