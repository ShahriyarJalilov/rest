package com.az.course.model.dto;

import com.az.course.entity.Detail;
import com.az.course.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class EmployeeDto {
    private Long id;
    private String name;
    private String surname;
    private String department;
    private BigDecimal salary;
    private Detail detail;




}
