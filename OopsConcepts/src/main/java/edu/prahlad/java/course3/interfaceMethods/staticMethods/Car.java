package edu.prahlad.java.course3.interfaceMethods.staticMethods;

public class Car implements Vehicle {

    //todo: cannot override an static method
    /*@Override
    public void cleanVehicle(){
        System.out.println("Vehicle > cleanVehicle - I'm cleaning the vehicle");
    }*/

    public static void main(String[] args) {
        Car car = new Car();


        //todo: since static method is hidden from implementor,
        // we can't call it from the object implementing the class
//        car.cleanVehicle();

        Vehicle.cleanVehicle();
    }
}
