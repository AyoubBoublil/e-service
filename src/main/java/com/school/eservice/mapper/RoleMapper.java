package com.school.eservice.mapper;

import com.school.eservice.dto.RoleDto;
import com.school.eservice.dto.UserDto;
import com.school.eservice.entity.Role;
import com.school.eservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto mapToRoleDto(Role role);

}
