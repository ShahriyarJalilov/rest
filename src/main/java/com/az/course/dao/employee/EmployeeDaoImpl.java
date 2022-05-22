package com.az.course.dao.employee;

import com.az.course.entity.Detail;
import com.az.course.entity.Employee;
import com.az.course.entity.User;
import com.az.course.mapper.DetailMapper;
import com.az.course.mapper.EmployeeMapper;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public List<EmployeeDto> getEmployeeList() {

        List<Employee> employeeList = entityManager
                .createQuery("from Employee", Employee.class).getResultList();
        return employeeList.stream()
                .map(EmployeeMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<DetailDto> getDetailList() {
        List<Detail> detailList = entityManager.createQuery("from Detail", Detail.class)
                .getResultList();

        return detailList.stream()
                .map(DetailMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto findById(Long id) {
        return EmployeeMapper.INSTANCE.toDto(entityManager.find(Employee.class, id));
    }

    @Override
    public void addEmployee(EmployeeDto employeeDto) {
        entityManager.persist(EmployeeMapper.INSTANCE.toEntity(employeeDto));
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return entityManager.find(User.class,1L);
    }

    @Override
    public void update(EmployeeDto employee) {
        entityManager.merge(EmployeeMapper.INSTANCE.toEntity(employee));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
