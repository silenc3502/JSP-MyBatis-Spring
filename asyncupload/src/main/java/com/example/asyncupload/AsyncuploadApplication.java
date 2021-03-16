package com.example.asyncupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.asyncupload.repository")
public class AsyncuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncuploadApplication.class, args);
    }

}
