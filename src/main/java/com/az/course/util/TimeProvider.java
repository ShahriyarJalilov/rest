package com.az.course.util;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.Date;

@Component
public class TimeProvider {
    private static final long serialVersionUID = -3301605591108950415L;
    public Date now(){
        return new Date();
    }
}
