package com.example.atm.ATMDemo.service;


import com.example.atm.ATMDemo.ResponseModel;
import com.example.atm.ATMDemo.exception.ATMException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ATMSrevice {

    Map<Integer, Integer> balanceMap  = new HashMap<Integer, Integer>() {{
        put(2000, 20);
        put(500, 20);
        put(200, 20);
        put(100, 20);
    }};

    public ResponseModel getDenominationMap(int amount) {

        ResponseModel rs = new ResponseModel();
        Map<Integer, Integer> balanceMapInitial = new HashMap<>(balanceMap);
        try {
        validateAmount(amount);

        Map<Integer, Integer> responseMap = new HashMap<>();


        TreeSet<Integer> dinominations = (TreeSet<Integer>) (new TreeSet<>(balanceMap.keySet())).descendingSet();

        int currentAmount = 0;

            for (int d : dinominations) {

                if (amount >= d ) {
                    int dinoCount = amount / d;
                    if(dinoCount <= balanceMap.get(d)) {
                        currentAmount = dinoCount * d;
                        amount = amount - currentAmount;
                        balanceMap.put(d,balanceMap.get(d)-dinoCount);
                        responseMap.put(d,dinoCount);
                        if (amount == 0){
                            rs.setDetails(responseMap);
                            rs.setMessage("Success");
                            return  rs;
                        }
                    }
                }
            }
            balanceMap = balanceMapInitial;
            throw new ATMException("Not able to dispense amount");
        } catch (Exception e) {
            balanceMap = balanceMapInitial;
            rs.setDetails(null);
            rs.setMessage(e.getMessage());
            return rs;
        }
    }

    public boolean validateAmount(int amount) {

        if (amount < 100 || amount>20000) {
            throw new ATMException("Amount is lower than min balance");
        }
        return true;
    }
}
