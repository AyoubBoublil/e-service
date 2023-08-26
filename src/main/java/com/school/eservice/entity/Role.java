package com.school.eservice.entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Role extends AbstractEntity{

    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

}
