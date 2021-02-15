package edu.prahlad.java.course2.oop.classhierarchies;

/**
 * Superclass (Animal),
 * which has all the common attributes and behaviors
 *
 * Subclass (Cat, Dog),
 * inherit state and behaviour from their parent,
 * defining only attributes or behaviour that differ
 *
 */
public class Animal extends Organism{

    public String gender;
    public int age;
    public double weight;
    public String color;

    public void breathe(){
        System.out.println("breathe");
    }

    public void eat(String food){
        System.out.println("Eat food > " + food);
    }

    public void run(String destination){
        System.out.println("run from here to destination > " + destination);
    }

    public void sleep(int hours){
        System.out.println("Sleep for hours > " + hours);
    }

}
