package com.school.eservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/resource")
public class AuthorizationController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Here is your resource");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcomeAdmin() {
        return "Welcome Admin";
    }

    @GetMapping("/teacher")
    @PreAuthorize("hasAuthority('ROLE_TEACHER')")
    public String welcomeTeacher() {
        return "Welcome Teacher";
    }

    @GetMapping("/student")
    @PreAuthorize("hasAuthority('ROLE_STUDENT')")
    public String welcomeStudent() {
        return "Welcome Student";
    }

}