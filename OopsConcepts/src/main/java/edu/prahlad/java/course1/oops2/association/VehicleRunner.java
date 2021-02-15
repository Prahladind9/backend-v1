package edu.prahlad.java.course1.oops2.association;

class Vehicle {

    // Complete this implementation
    int id;
    String model;

    public Vehicle(String model, int id){
        this.id = id;
        this.model = model;
    }

}

class Driver {

    // Complete this implementation
    String driverName;
    Vehicle vehicle;

    public Driver(String driverName, Vehicle vehicle){
        this.driverName = driverName;
        this.vehicle = vehicle;
    }

}

//Association example
public class VehicleRunner {

    public static void main(String args[]) {
        // Creating a Vehicle object with model: "Volvo S60", and id: "4453"
        Vehicle vehicle = new Vehicle("Volvo S60", 4453);
        // Creating a Driver object having name: "John" and passing the
        // vehicle in its constructor
        Driver driver = new Driver("John", vehicle);
        System.out.println(driver.driverName +
                " is a driver of car Id: " + driver.vehicle.id);
    }

}
