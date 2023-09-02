package com.school.eservice.exception;

public class IncorrectDataRequestException extends RuntimeException {
    private String message;

    public IncorrectDataRequestException() {
    }

    public IncorrectDataRequestException(String message) {
        super(message);
        this.message = message;
    }
}
