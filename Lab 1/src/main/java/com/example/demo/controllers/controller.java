package com.example.demo.controllers;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Employee")

public class controller {

    @GetMapping
    public String getHello() {
        return "Get: get Employee Successful";
    }

    @PostMapping
    public String postHello() {
        return "Post: Post Employee Successful";
    }

    @DeleteMapping
    public String DeleteHello() {
        return "Delete: Delete Employee Successful";
    }

    @PutMapping
    public String putHello() {
        return "Put: put Employee Successful";
    }
}
