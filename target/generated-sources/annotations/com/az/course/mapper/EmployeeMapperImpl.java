package com.az.course.mapper;

import com.az.course.entity.Employee;
import com.az.course.model.dto.EmployeeDto;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T12:01:56-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
*/
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setId( employee.getId() );
        employeeDto.setName( employee.getName() );
        employeeDto.setSurname( employee.getSurname() );
        employeeDto.setDepartment( employee.getDepartment() );
        employeeDto.setSalary( employee.getSalary() );
        employeeDto.setDetail( employee.getDetail() );

        return employeeDto;
    }

    @Override
    public Employee toEntity(EmployeeDto employeeDto) {
        if ( employeeDto == null ) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId( employeeDto.getId() );
        employee.setName( employeeDto.getName() );
        employee.setSurname( employeeDto.getSurname() );
        employee.setDepartment( employeeDto.getDepartment() );
        employee.setSalary( employeeDto.getSalary() );
        employee.setDetail( employeeDto.getDetail() );

        return employee;
    }
}
