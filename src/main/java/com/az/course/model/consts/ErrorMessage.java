package com.az.course.model.consts;

public enum ErrorMessage {
    USER_NOT_FOUND("User by this id not found"),
    TOKEN_IS_EMPTY("Token is empty!"),
    INVALID_TOKEN("Token is invalid"),
    TOKEN_EXPIRED("Access token is expired"),
    UNAUTHORIZED("Username and password is incorrect");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    }
