package com.rsnvtech.erp.edu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StudentMain {
    public static void main(String[] args) {
        SpringApplication.run(StudentMain.class);
    }
}