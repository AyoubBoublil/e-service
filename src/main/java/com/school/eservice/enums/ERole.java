package com.school.eservice.enums;

public enum ERole {
    ROLE_ADMIN,
    ROLE_TEACHER,
    ROLE_STUDENT;

    public static ERole findERoleByName(String roleName) {
        for (ERole v : values()) {
            if (v.name().equalsIgnoreCase(roleName)) {
                return v;
            }
        }
        return null;
    }

}
