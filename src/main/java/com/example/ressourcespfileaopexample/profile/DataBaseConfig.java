package com.example.ressourcespfileaopexample.profile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataBaseConfig {

    @Value("${spring.datasource.url}")
    private String jdbcUrl;


    public String connect(){

        return jdbcUrl;

    }

}
