package com.az.course.service;

import com.az.course.entity.Employee;
import com.az.course.entity.User;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {
    List<EmployeeDto> getEmployeeList();
    List<DetailDto>getDetailList();
    EmployeeDto  findById(Long id);
    void addEmployee(EmployeeDto employeeDto);;
    public User findByUsernameAndPassword(String username, String password);
    void update(EmployeeDto employee);
    void delete(Long id);
}
