package com.markcorazon.animals.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HashMap<String, String> formattedErrors = new HashMap<>();
        List<ObjectError> errors = ex.getBindingResult().getAllErrors();
        errors.forEach(error -> {
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            formattedErrors.put(field, message);
        });
        return new ResponseEntity<>(formattedErrors, HttpStatus.BAD_REQUEST);
    }
}
