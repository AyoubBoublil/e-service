package com.school.eservice.service.impl;

import com.school.eservice.dto.UserDto;
import com.school.eservice.entity.Role;
import com.school.eservice.entity.User;
import com.school.eservice.enums.ERole;
import com.school.eservice.exception.IncorrectDataRequestException;
import com.school.eservice.exception.RoleNotFoundException;
import com.school.eservice.exception.UserAlreadyExistsException;
import com.school.eservice.exception.UserNotFoundException;
import com.school.eservice.mapper.UserMapper;
import com.school.eservice.repository.RoleRepository;
import com.school.eservice.repository.UserRepository;
import com.school.eservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
        if (Objects.nonNull(userDto)) {
            if (userRepository.findByEmail(userDto.getEmail()).isPresent())
                throw new UserAlreadyExistsException("Email is already used");
            // get role
            Role role = roleRepository.findByName(ERole.ROLE_ADMIN).orElseThrow(() -> new RoleNotFoundException("Role not found"));
            // save user
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setPhone(userDto.getPhone());
            user.setRoles(Set.of(role));
            String tempPwd = RandomStringUtils.randomAlphanumeric(10);
            log.info("temp password " + tempPwd);
            user.setPassword(tempPwd);
            user = userRepository.save(user);
            return userMapper.mapToUserDto(user);
        }
        throw new IncorrectDataRequestException("The data is incorrect");
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        // get current user to modify from BDD
        User user = userRepository.findById(userDto.getId()).orElseThrow(() -> new UserNotFoundException("User not found"));
        userMapper.updateUserEntityFromDto(userDto, user);
        user = userRepository.save(user);
        return userMapper.mapToUserDto(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        // user.setEnabled(0);
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userMapper.mapToUserDtos(userRepository.findAll());
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
        return userMapper.mapToUserDto(user);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }
}
