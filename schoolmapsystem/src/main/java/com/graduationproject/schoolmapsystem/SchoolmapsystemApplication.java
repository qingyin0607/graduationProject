package com.graduationproject.schoolmapsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.graduationproject.schoolmapsystem.mapper")
public class SchoolmapsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolmapsystemApplication.class, args);
    }

}
