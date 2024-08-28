package com.example.apisencilla.apisencilla.Controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.example.apisencilla.apisencilla.Models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundEx(Exception ex){
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError("Api Rest Not Found");
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<Error> notFoundApi(Exception ex){
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError("Method Not Found");
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> getNotFound(Exception ex){
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setError(ex.getMessage());
        error.setDate(new Date());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
