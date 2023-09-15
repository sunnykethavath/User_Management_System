package com.example.UMS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanBag {
    @Bean
    public List<UserManagementSystem> getDataSource(){
        return new ArrayList<>();
    }
}
