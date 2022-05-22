package com.az.course.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto {
    private Long id;
    private String city;
    private String phoneNumber;
    private String email;
    private EmployeeDto employee;

}
