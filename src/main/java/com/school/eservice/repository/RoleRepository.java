package com.school.eservice.repository;

import com.school.eservice.entity.Role;
import com.school.eservice.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole roleName);

}
