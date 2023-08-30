package com.school.eservice.controller;

import com.school.eservice.dto.UserDto;
import com.school.eservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/manage-users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto))
            return ResponseEntity.ok(userService.createUser(userDto));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto))
            return ResponseEntity.ok(userService.updateUser(userDto));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
