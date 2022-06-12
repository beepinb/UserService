package com.example.userservice.exception;

public class UserAlreadyFoundException extends RuntimeException{
    public UserAlreadyFoundException(String message){
        super(message);

    }
}
