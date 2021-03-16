package com.example.mybatisdynamicsql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisdynamicsql.repository")
public class MybatisdynamicsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisdynamicsqlApplication.class, args);
    }

}
