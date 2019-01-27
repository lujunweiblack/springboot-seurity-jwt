package com.example.seurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@MapperScan("com.example.seurity.mapper")
public class SpringbootSeurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSeurityApplication.class, args);
    }
}

