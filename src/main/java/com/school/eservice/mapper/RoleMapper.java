package com.school.eservice.mapper;

import com.school.eservice.dto.RoleDto;
import com.school.eservice.dto.UserDto;
import com.school.eservice.entity.Role;
import com.school.eservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping( target = "name", source = "name" )
    RoleDto mapToRoleDto(Role role);

}
