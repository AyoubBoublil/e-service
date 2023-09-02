package com.school.eservice.service;

import com.school.eservice.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long userId);
    List<UserDto> getAllUsers();
    UserDto getUserById(Long userId);

}
