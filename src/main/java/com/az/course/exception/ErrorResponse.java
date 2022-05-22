package com.az.course.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {
    public String message;

    public static ErrorResponse of(String message){
        return new ErrorResponse(message);
    }
}
