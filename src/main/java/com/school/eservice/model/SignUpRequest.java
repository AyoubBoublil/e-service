package com.school.eservice.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {
    @NotBlank(message = "First name should not be empty or null")
    private String firstName;
    @NotBlank(message = "Last name should not be empty or null")
    private String lastName;
    @NotBlank(message = "Email should not be empty or null")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = "Number should not be empty or null")
    @Min(value = 6, message = "The password should have at least 6 characters")
    private String password;
    @NotBlank(message = "Number should not be empty or null")
    private String phone;
    private Set<String> roles;
}
