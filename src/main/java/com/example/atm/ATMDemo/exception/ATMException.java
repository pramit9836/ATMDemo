package com.example.atm.ATMDemo.exception;

public class ATMException extends RuntimeException {

    String message;

    public ATMException(String message) {
        super(message);
        this.message = message;
    }

}
