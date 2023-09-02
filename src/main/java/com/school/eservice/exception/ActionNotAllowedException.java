package com.school.eservice.exception;

public class ActionNotAllowedException extends RuntimeException {
    private String message;

    public ActionNotAllowedException() {
    }

    public ActionNotAllowedException(String message) {
        super(message);
        this.message = message;
    }
}
