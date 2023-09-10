package com.school.eservice.service;

import com.school.eservice.model.JwtAuthenticationResponse;
import com.school.eservice.model.SignUpRequest;
import com.school.eservice.model.SigninRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse signUp(SignUpRequest request);

    JwtAuthenticationResponse signIn(SigninRequest request);

}
