package edu.prahlad.java.course1.oops2.association;

abstract class Train {
    protected String name;
    protected int capacity;

    public Train(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }

    public String getDetails(){
        return "";
    }
}

//Make necessary changes in the classes given below
class CargoTrain extends Train {
    public CargoTrain(String name, int capacity){
        super(name, capacity);
    }

    public String getDetails(){
        return super.name + " is a cargo train having a capacity of "+ super.capacity +" tons.";
    }
}

class PassengerTrain extends Train {
    public PassengerTrain(String name, int capacity){
        super(name, capacity);
    }

    public String getDetails(){
        return super.name + " is a passenger train having a capacity of "+ super.capacity +" passengers.";
    }
}
public class TrainRunner {
}
