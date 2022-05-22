package com.az.course.service;

import com.az.course.dao.employee.EmployeeDao;
import com.az.course.entity.User;
import com.az.course.exception.EmployeeNotFoundException;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Override
    @Transactional
    public List<EmployeeDto> getEmployeeList() {
        return employeeDao.getEmployeeList();
    }

    @Override
    @Transactional
    public List<DetailDto> getDetailList() {
        return employeeDao.getDetailList();
    }

    @Override
    @Transactional
    public EmployeeDto findById(Long id) {
        if(employeeDao.findById(id)==null){
            throw new EmployeeNotFoundException();
        }
        return employeeDao.findById(id);
    }


    @Override
    @Transactional
    public void addEmployee(EmployeeDto employeeDto) {
      employeeDao.addEmployee(employeeDto);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return employeeDao.findByUsernameAndPassword(username,password);
    }

    @Override
    @Transactional
    public void update(EmployeeDto employee) {
      employeeDao.update(employee);
    }

    @Override
    public void delete(Long id) {
       employeeDao.delete(id);
    }
}
