package com.example.bankflow.api.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpHeaders;

@Getter
public class ApplicationStatusException extends RuntimeException {

    private HttpStatus httpStatus;

    public ApplicationStatusException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
