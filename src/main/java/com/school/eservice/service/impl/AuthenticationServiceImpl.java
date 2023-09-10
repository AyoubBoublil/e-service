package com.school.eservice.service.impl;

import com.school.eservice.entity.Role;
import com.school.eservice.entity.User;
import com.school.eservice.enums.ERole;
import com.school.eservice.exception.IncorrectDataRequestException;
import com.school.eservice.exception.RoleNotFoundException;
import com.school.eservice.exception.UserAlreadyExistsException;
import com.school.eservice.model.JwtAuthenticationResponse;
import com.school.eservice.model.SignUpRequest;
import com.school.eservice.model.SigninRequest;
import com.school.eservice.repository.RoleRepository;
import com.school.eservice.repository.UserRepository;
import com.school.eservice.service.AuthenticationService;
import com.school.eservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    @Override
    public JwtAuthenticationResponse signUp(SignUpRequest request) {
        if (Objects.nonNull(request)) {
            // verify roles
            if (request.getRoles() == null || request.getRoles().isEmpty())
                throw new IncorrectDataRequestException("You have to assign at least one role");
            // verify user email if already exist
            if (userRepository.findByEmail(request.getEmail()).isPresent())
                throw new UserAlreadyExistsException("Email is already used");
            // get role by name
            Set<Role> roles = new HashSet<>();
            request.getRoles()
                    .forEach(role -> {
                        roles.add(roleRepository.findByName(ERole.findERoleByName(role)).orElseThrow(() -> new RoleNotFoundException("Role not found")));
                    });
            var user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .phone(request.getPhone())
                    .roles(roles)
                    .build();
            user = userRepository.save(user);
            var jwt = jwtService.generateToken(user);
            return JwtAuthenticationResponse.builder().token(jwt).build();
        }
        throw new IncorrectDataRequestException("The data is incorrect");
    }

    @Override
    public JwtAuthenticationResponse signIn(SigninRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = userRepository.findByEmail(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
