package com.az.course.model.response;

import com.az.course.model.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse  extends Status {
    private String token;

    public TokenResponse(int code,String message){
        super(code,message);
    }
}
