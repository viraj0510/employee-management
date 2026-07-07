package com.atmaram.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Employee Management System!";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running successfully!";
    }
}