package com.spring.professional.exam.beans;

import org.springframework.stereotype.Component;

@Component
public class Gearbox {
    void putIntoDrivePosition(){
        System.out.println("Putting Gearbox into position");
    }
}
