package com.example.atm.ATMDemo;

import java.util.Map;

public class ResponseModel {

    String message;
    Map<Integer, Integer> details;

    public String getMessage() {
        return message;
    }

    public Map<Integer, Integer> getDetails() {
        return details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(Map<Integer, Integer> details) {
        this.details = details;
    }
}
