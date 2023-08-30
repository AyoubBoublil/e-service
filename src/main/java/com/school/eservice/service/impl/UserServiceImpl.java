package com.school.eservice.service.impl;

import com.school.eservice.dto.UserDto;
import com.school.eservice.entity.Role;
import com.school.eservice.entity.User;
import com.school.eservice.enums.UserRole;
import com.school.eservice.mapper.UserMapper;
import com.school.eservice.repository.RoleRepository;
import com.school.eservice.repository.UserRepository;
import com.school.eservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = new User();
        if (userDto != null) {
            // save role
            Role role = new Role();
            role.setRoleName(UserRole.ADMIN.name());
            role = roleRepository.save(role);
            // save user
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            user.setRoles(List.of(role));
            String tempPwd = RandomStringUtils.randomAlphanumeric(10);
            log.info("temp password " + tempPwd);
            user.setPassword(tempPwd);
            user = userRepository.save(user);
        }
        return userMapper.mapToUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        // get current user to modify from BDD
        User user = userRepository.findById(userDto.getId()).get();
        userMapper.updateUserEntityFromDto(userDto,user);
        user = userRepository.save(user);
        return userMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(Long idUser) {

    }
}