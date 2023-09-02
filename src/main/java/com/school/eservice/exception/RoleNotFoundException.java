package com.school.eservice.exception;

public class RoleNotFoundException extends RuntimeException {
    private String message;

    public RoleNotFoundException() {
    }

    public RoleNotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
