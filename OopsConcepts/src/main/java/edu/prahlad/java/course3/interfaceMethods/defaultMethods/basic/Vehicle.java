package edu.prahlad.java.course3.interfaceMethods.defaultMethods.basic;

public interface Vehicle {
    void cleanVehicle();
    default void startVehicle(){
        System.out.println("Vehicle is starting");
    }
}
