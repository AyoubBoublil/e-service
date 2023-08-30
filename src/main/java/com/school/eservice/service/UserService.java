package com.school.eservice.service;

import com.school.eservice.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    void deleteUser(Long idUser);

}
