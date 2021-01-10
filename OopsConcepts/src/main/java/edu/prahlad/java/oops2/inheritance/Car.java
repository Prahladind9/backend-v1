package edu.prahlad.java.oops2.inheritance;

// Base Class Vehicle
class Vehicle {

    // Private Fields
    private String make;
    private String color;
    private int year;
    private String model;

    //default  - only to check super
    //fuelCap field inside SuperClass
    int fuelCap = 90;


    // Parameterized Constructor
    public Vehicle(String make, String color, int year, String model) {
        this.make = make;
        this.color = color;
        this.year = year;
        this.model = model;
    }

    // public method to print details
    public void printDetails() {
        System.out.println("Manufacturer: " + make);
        System.out.println("Color: " + color);
        System.out.println("Year: " + year);
        System.out.println("Model: " + model);
    }

}

// Derived Class Car
public class Car extends Vehicle {

    // Private field
    private String bodyStyle;

    int fuelCap = 50; //fuelCap field inside SubClass

    // Parameterized Constructor
    public Car(String make, String color, int year, String model, String bodyStyle) {
        super(make, color, year, model);  //calling parent class constructor

        this.bodyStyle = bodyStyle;
    }

    public void carDetails() {  //details of car
        printDetails();         //calling method from parent class
        System.out.println("Body Style: " + bodyStyle);
    }

    public void printDetails() {
//        super.printDetails();
        //accessing the field of parent class using super*/
        System.out.println("Fuel Capacity from the Vehicle class: " + super.fuelCap);
        //without using super the field of current class shadows the field of parent class*/
        System.out.println("Fuel Capacity from the Car class: " + fuelCap);

    }

}

class Main {

    public static void main(String[] args) {
        Car elantraSedan = new Car("Hyundai", "Red", 2019, "Elantra", "Sedan"); //creation of car Object
        elantraSedan.carDetails(); //calling method to print details
        elantraSedan.printDetails();
    }

}