package com.school.eservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "First name should not be empty or null")
    private String firstName;
    @NotBlank(message = "Last name should not be empty or null")
    private String lastName;
    @NotBlank(message = "Email should not be empty or null")
    @Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;
    @NotBlank(message = "Number should not be empty or null")
    private String phone;
}
