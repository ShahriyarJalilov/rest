package com.az.course.model;

import lombok.*;
import lombok.experimental.Accessors;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Status {

    private int code;
    private String message;

    public static Status of(int code,String message){
        return new Status()
                .setCode(code)
                .setMessage(message);
    }
}
