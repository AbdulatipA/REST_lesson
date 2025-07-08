package org.example.rest_lesson.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleOrderNotFoundException(OrderNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();

        errorResponse.put("message", ex.getMessage());
        errorResponse.put("code", "404");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
