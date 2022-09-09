package ru.shibaev.bank.model.exceptions;

import org.springframework.http.HttpStatus;

public class UserException extends Exception {

    public HttpStatus statusCode;

    public UserException(String message, HttpStatus statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
