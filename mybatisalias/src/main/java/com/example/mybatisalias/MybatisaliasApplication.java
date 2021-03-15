package com.example.mybatisalias;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatisalias.repository")
public class MybatisaliasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisaliasApplication.class, args);
    }

}
