package edu.prahlad.java.course1.oops2.interfaces;

interface Flyable{
    void fly();
}

class Birds implements Flyable{
    @Override
    public void fly() {
        System.out.println("wih wings");
    }
}

class Aeroplane implements Flyable{
    @Override
    public void fly() {
        System.out.println("wih fuel");
    }
}
public class FlyableRunner {
    public static void main(String[] args) {
        Flyable[] flyableObjects =  {new Birds(), new Aeroplane()};
        for (Flyable object: flyableObjects){
            object.fly();
        }
    }
}
