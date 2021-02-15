package edu.prahlad.java.course1.oops;

public class MotorBike {

    //State
    private int speed;

    public MotorBike(int speed){
        this.speed = speed;
    }

    //Behaviour
    //method >>
    //  inputs - int speed
    //  outputs - void
    //  name - setSpeed

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if(speed > 0)
            this.speed = speed;
    }

    public void increaseSpeed(int howMuch){
        setSpeed(this.speed + howMuch);
    }

    public void decreaseSpeed(int howMuch){
        setSpeed(this.speed - howMuch);
    }

    public void start(){
        System.out.println("Bike Started");
    }

}
