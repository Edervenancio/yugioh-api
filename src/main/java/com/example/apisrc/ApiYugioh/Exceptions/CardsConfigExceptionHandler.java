package com.example.apisrc.ApiYugioh.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CardsConfigExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<CardsConfigErrorResponse> handleException (CardsConfigNotFoundException exc){
        CardsConfigErrorResponse error = new CardsConfigErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<CardsConfigErrorResponse> handleException (Exception exc){
        CardsConfigErrorResponse error = new CardsConfigErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());


        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
