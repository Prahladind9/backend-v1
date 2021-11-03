package com.spring.professional.exam;

import com.spring.professional.exam.beans.Car;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

    public static void main(String[] args) {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)){
            Car car = context.getBean(Car.class);
            car.drive();
        }
    }

}
