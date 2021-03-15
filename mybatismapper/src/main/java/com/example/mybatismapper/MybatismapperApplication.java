package com.example.mybatismapper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.mybatismapper.mapper")
public class MybatismapperApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatismapperApplication.class, args);
    }

}
