package com.az.course.model.dto;

import com.az.course.model.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class EmployeeResponse {
    private Status status;
    private List<EmployeeDto> employee;

    public static EmployeeResponse of(Status status,List<EmployeeDto> employee){
        return new EmployeeResponse()
                .setStatus(status)
                .setEmployee(employee);
    }


}
