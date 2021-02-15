package edu.prahlad.java.course1.oops;

public class MotorBikeRunner {
    public static void main(String[] args) {
        MotorBike ducati = new MotorBike(100);
        MotorBike honda = new MotorBike(200);
        System.out.println(ducati.getSpeed());

        ducati.start();
        honda.start();

        ducati.setSpeed(100);
        ducati.increaseSpeed(100);
        ducati.decreaseSpeed(50);
        System.out.println(ducati.getSpeed());
//
//        honda.setSpeed(80);
//        System.out.println(honda.getSpeed());

    }
}
