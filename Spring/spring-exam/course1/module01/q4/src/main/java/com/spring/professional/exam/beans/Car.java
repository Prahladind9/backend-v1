package com.spring.professional.exam.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    @Autowired
    private Battery battery;
    @Autowired
    private Engine engine;
    @Autowired
    private Gearbox gearbox;
    @Autowired
    private Wheels wheels;

    public void drive(){
        battery.supplyPower();
        engine.start();
        gearbox.putIntoDrivePosition();
        wheels.roll();
    }
}
