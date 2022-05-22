package com.az.course.mapper;

import com.az.course.entity.Detail;
import com.az.course.entity.Employee;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-17T12:01:56-0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
*/
public class DetailMapperImpl implements DetailMapper {

    @Override
    public DetailDto toDto(Detail detail) {
        if ( detail == null ) {
            return null;
        }

        DetailDto detailDto = new DetailDto();

        detailDto.setEmployee( employeeToEmployeeDto( detail.getEmployee() ) );
        detailDto.setId( detail.getId() );
        detailDto.setCity( detail.getCity() );
        detailDto.setPhoneNumber( detail.getPhoneNumber() );
        detailDto.setEmail( detail.getEmail() );

        return detailDto;
    }

    protected EmployeeDto employeeToEmployeeDto(Employee employee) {
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
}
