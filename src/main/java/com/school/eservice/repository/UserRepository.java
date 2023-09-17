package com.school.eservice.repository;

import com.school.eservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndEnabled(String email, Integer enabled);

    List<User> findAllByEnabledOrderByCreatedDateAsc(Integer enabled);
}
