package com.example.Demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>("Resource not found "+ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProcessingException.class)
    public ResponseEntity<String> handlerProcessingException(ProcessingException ex){
        return new ResponseEntity<>("Shoot Something went Wrong "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handlerException(Exception ex){
        return new ResponseEntity<>("Unknown exception "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
