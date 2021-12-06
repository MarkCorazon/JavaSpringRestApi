package com.markcorazon.animals;

import com.markcorazon.animals.exceptions.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlers {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DataNotFoundException.class)
    public ErrorResponse handleDataException(DataNotFoundException exception, HttpServletRequest request) {
        return new ErrorResponse(String.format("Data from %s with id %d could not be found", exception.getRepository(), exception.getIndex()));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponse handleRuntimeException(RuntimeException exception) {
        return new ErrorResponse("Error: " + exception.getMessage());
    }

    public static class ErrorResponse {
        private String error;

        public ErrorResponse(String message) {
            this.error = message;
        }

        public String getError() {
            return this.error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}