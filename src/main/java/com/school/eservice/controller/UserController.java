package com.school.eservice.controller;

import com.school.eservice.dto.UserDto;
import com.school.eservice.exception.IncorrectDataRequestException;
import com.school.eservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            throw new IncorrectDataRequestException("Incorrect data");
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
        if (Objects.nonNull(userDto))
            return ResponseEntity.ok(userService.updateUser(userDto));
        else
            throw new IncorrectDataRequestException("Incorrect data");
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        if (Objects.nonNull(userId)) {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            throw new IncorrectDataRequestException("Incorrect data");
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        if (Objects.nonNull(userId))
            return ResponseEntity.ok(userService.getUserById(userId));
        else
            throw new IncorrectDataRequestException("Incorrect data");
    }

}
