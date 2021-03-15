package com.example.mybatismember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatismember.repository")
public class MybatismemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatismemberApplication.class, args);
    }

}
