package com.az.course.controller;

import com.az.course.model.Status;
import com.az.course.model.dto.DetailDto;
import com.az.course.model.dto.EmployeeDto;
import com.az.course.model.dto.EmployeeResponse;
import com.az.course.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.az.course.model.consts.SuccessMessage.SUCCESS_MESSAGE;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class RestControllers {

    private final EmployeeService employeeService;


    @GetMapping(value = "/")
    @ResponseStatus(OK)
    // @LogAspect
    @Cacheable(cacheNames = "ok")
    public EmployeeResponse employee(@RequestHeader("Authorization") String token) {
        return EmployeeResponse.of(
                Status.of(
                        SUCCESS_MESSAGE.getCode(),
                        SUCCESS_MESSAGE.getMessage()
                ),
                employeeService.getEmployeeList()
        );
    }

    @GetMapping(value = "/detail")
    public List<DetailDto> detail() {
        return employeeService.getDetailList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    @ResponseStatus(OK)
    public EmployeeDto findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/")
    public void remove(@RequestParam("id") Long id) {
        employeeService.delete(id);
    }

    @PostMapping("/")
    public EmployeeDto addEmployee(@RequestBody EmployeeDto employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping
    public EmployeeDto update(@RequestBody EmployeeDto employee) {
        employeeService.update(employee);
        return employee;
    }

}
