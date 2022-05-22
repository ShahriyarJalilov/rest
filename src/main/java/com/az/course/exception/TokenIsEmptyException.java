package com.az.course.exception;

import com.az.course.model.consts.ErrorMessage;

import static com.az.course.model.consts.ErrorMessage.TOKEN_IS_EMPTY;

public class TokenIsEmptyException extends RuntimeException {
    public TokenIsEmptyException(){
        super(TOKEN_IS_EMPTY.getMessage());
    }
}
