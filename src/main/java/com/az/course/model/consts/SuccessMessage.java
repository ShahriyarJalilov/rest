package com.az.course.model.consts;

public enum SuccessMessage {
    SUCCESS_MESSAGE(200,"Success");

    private final int code;
    private final String message;

    SuccessMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    public int getCode() {
        return code;
    }
}
