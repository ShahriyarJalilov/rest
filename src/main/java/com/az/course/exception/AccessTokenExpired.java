package com.az.course.exception;

import com.az.course.model.consts.ErrorMessage;

import static com.az.course.model.consts.ErrorMessage.INVALID_TOKEN;
import static com.az.course.model.consts.ErrorMessage.TOKEN_EXPIRED;

public class AccessTokenExpired extends RuntimeException {
    public AccessTokenExpired(){
        super(TOKEN_EXPIRED.getMessage());
    }
}
