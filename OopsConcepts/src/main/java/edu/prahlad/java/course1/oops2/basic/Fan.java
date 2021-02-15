package edu.prahlad.java.course1.oops2.basic;

public class Fan {

    //State
    private String make;
    private double radius;
    private String color;

    private boolean isOn;
    private byte speed; //0 to 5 >> can use enum instead

    //Creation
    public Fan(String make, double radius, String color) {
        this.make = make;
        this.radius = radius;
        this.color = color;
    }

    //State
    //Consumer perspective
    public void switchOn(){
        this.isOn = true;
        setSpeed((byte) 5);
    }

    public void switchOff(){
        this.isOn = false;
        setSpeed((byte)0);
    }

    public void setSpeed(byte speed){
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Fan{" +
                "make='" + make + '\'' +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                ", isOn=" + isOn +
                ", speed=" + speed +
                '}';
    }
}
