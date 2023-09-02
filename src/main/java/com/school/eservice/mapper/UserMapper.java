package com.school.eservice.mapper;

import com.school.eservice.dto.UserDto;
import com.school.eservice.entity.User;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapToUserDto(User user);
    List<UserDto> mapToUserDtos(List<User> users);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserEntityFromDto(UserDto userDto, @MappingTarget User user);


}
