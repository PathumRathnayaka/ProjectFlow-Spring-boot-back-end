package com.project.ProjectFlow.exception;

import com.project.ProjectFlow.customstatuscode.ErrorStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ErrorStatus handleResourceNotFound(ResourceNotFoundException ex) {
        return new ErrorStatus(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorStatus handleIllegalArgument(IllegalArgumentException ex) {
        return new ErrorStatus(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorStatus handleGeneralError(Exception ex) {
        ex.printStackTrace(); // log for debugging
        return new ErrorStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Something went wrong. Please try again later.");
    }
}
