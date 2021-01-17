package org.example.springboot.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 **/
@SpringBootApplication
@MapperScan("org.example.springboot.integration.mybatis.mapper")
public class SpringBootIntegrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationApplication.class, args);
    }
}
