package com.school.eservice.entity;

import com.school.eservice.enums.ERole;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Role extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

}
