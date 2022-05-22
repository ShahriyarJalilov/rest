package com.az.course.exception;

import static com.az.course.model.consts.ErrorMessage.USER_NOT_FOUND;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(){
        super(USER_NOT_FOUND.getMessage());
    }
}
