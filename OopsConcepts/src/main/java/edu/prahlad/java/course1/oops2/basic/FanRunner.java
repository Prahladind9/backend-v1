package edu.prahlad.java.course1.oops2.basic;

public class FanRunner {
    public static void main(String[] args) {
        Fan fan = new Fan("Rao", 0.3456, "Green");
        fan.switchOn();
        System.out.println(fan);
    }
}
