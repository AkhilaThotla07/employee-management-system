package com.ems.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DepartmentNotFoundException.class)
    public Map<String, String> handleDepartmentException(DepartmentNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public Map<String, String> handleEmployeeException(EmployeeNotFoundException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("message", ex.getMessage());
        return error;
    }
    
    @ExceptionHandler(DepartmentAlreadyExistException.class)
    public Map<String,String> handleDepartmentExistException(DepartmentAlreadyExistException ex){
    	Map<String, String> error=new HashMap<>();
    	error.put("message", ex.getMessage());
    	return error;
    }
    
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public Map<String,String> handleEmployeeExistException(EmployeeAlreadyExistsException ex){
    	Map<String, String> error=new HashMap<>();
    	error.put("message", ex.getMessage());
    	return error;
    }
    

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return errors;
    }
}