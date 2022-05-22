package com.az.course.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    // elave eledim
    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();


    }
}
