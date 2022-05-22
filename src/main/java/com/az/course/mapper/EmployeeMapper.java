package com.az.course.mapper;

import com.az.course.entity.Employee;
import com.az.course.model.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);


    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

}
