package com.az.course.dao.employee;

import com.az.course.entity.Employee;
import com.az.course.entity.User;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeDao {
    List<EmployeeDto>getEmployeeList();
    List<DetailDto>getDetailList();
    EmployeeDto findById(Long id);
    void addEmployee(EmployeeDto employeeDto);
    User findByUsernameAndPassword(String username,String password);
    void update(EmployeeDto employeeDto);
    void delete(Long id);
}
