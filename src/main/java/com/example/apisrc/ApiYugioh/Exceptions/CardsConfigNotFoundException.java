package com.example.apisrc.ApiYugioh.Exceptions;

public class CardsConfigNotFoundException extends RuntimeException {
    public CardsConfigNotFoundException(String message) {
        super(message);
    }

    public CardsConfigNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardsConfigNotFoundException(Throwable cause) {
        super(cause);
    }
}
