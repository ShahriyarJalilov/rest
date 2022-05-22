package com.az.course.model.request;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String password;
}
