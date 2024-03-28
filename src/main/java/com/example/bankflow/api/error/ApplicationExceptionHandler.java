package com.example.bankflow.api.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ApplicationStatusException.class)
    public ResponseEntity<?> handlerApplicationException(final ApplicationStatusException ex) {
        log.error("Произошла ошибка {}:{}", ex.getHttpStatus().value(), ex.getMessage(), ex);
        return ResponseEntity.status(ex.getHttpStatus().value()).body(ex.getMessage());
    }

}
