package com.school.eservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends AbstractEntity{

    private String roleName;
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

}
