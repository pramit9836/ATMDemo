package com.example.atm.ATMDemo.controller;


import com.example.atm.ATMDemo.ResponseModel;
import com.example.atm.ATMDemo.service.ATMSrevice;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/atm")
public class ATMController {

    @Autowired
    ATMSrevice atmSrevice;

    @GetMapping(value = "/withdraw")
    public  ResponseEntity<ResponseModel> getMoney(@RequestParam int amount) {

        ResponseModel rs = atmSrevice.getDenominationMap(amount);

        return new ResponseEntity<>(rs, HttpStatus.OK);
        /*if (returnMap != null) {
            return new ResponseEntity<>(rs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }*/
    }
}
