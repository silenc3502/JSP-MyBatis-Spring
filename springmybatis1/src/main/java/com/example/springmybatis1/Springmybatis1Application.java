package com.example.springmybatis1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.springmybatis1.mapper")
public class Springmybatis1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springmybatis1Application.class, args);
    }

}
