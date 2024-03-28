package com.example.bankflow.api.error;

import org.springframework.http.HttpStatus;

public class ValidationException extends ApplicationStatusException {

    public ValidationException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
