package com.school.eservice.controller;

import com.school.eservice.model.JwtAuthenticationResponse;
import com.school.eservice.model.SignUpRequest;
import com.school.eservice.model.SigninRequest;
import com.school.eservice.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;

// @CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JwtAuthenticationResponse> signUp(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @PostMapping("/signIn")
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}