package ru.job4j.site.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.job4j.site.domain.ErrorMessage;
import ru.job4j.site.exception.RestTemplateErrorException;

@RestControllerAdvice
public class ExceptionApiHandler {
    @ExceptionHandler(RestTemplateErrorException.class)
    public ResponseEntity<ErrorMessage> notFoundException(RestTemplateErrorException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(exception.getMessage()));
    }
}
