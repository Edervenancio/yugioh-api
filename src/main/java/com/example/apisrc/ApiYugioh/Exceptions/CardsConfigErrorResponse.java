package com.example.apisrc.ApiYugioh.Exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardsConfigErrorResponse {

    private int status;

    private String message;

    private long timeStamp;


    public CardsConfigErrorResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public CardsConfigErrorResponse(){

    }
}
