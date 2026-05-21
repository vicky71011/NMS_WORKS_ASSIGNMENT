package com.studentresult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentResultSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentResultSystemApplication.class, args);
        System.out.println("====================================================");
        System.out.println("  Student Result Management System is RUNNING!");
        System.out.println("  Open: http://localhost:8080");
        System.out.println("  REST API: http://localhost:8080/api/students");
        System.out.println("====================================================");
    }
}
