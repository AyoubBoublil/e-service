package com.school.eservice.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class User extends AbstractEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private boolean enabled;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

}
