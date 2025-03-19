package com.project.traini8.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

//Global exception handler to handle application-wide exceptions.

//Enables global exception handling for all controllers
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Handles validation errors when input request fields are invalid.
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>(); //Stores validation error messages
        
        //Extract field errors and store field name -> error message mapping
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        
        //Return a BAD_REQUEST (400) response with error details
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
