package com.spring.professional.exam.beans;

import org.springframework.stereotype.Component;

@Component
public class Battery {
    void supplyPower(){
        System.out.println("Supplying Power");
    }
}
