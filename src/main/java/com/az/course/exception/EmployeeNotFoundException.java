package com.az.course.exception;

import static com.az.course.model.consts.ErrorMessage.USER_NOT_FOUND;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super(USER_NOT_FOUND.getMessage());
    }
}
