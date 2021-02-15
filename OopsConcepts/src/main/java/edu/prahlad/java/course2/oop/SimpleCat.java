package edu.prahlad.java.course2.oop;

//Cat - Name
public class SimpleCat {

    /**
     * Visibility
     *
     * >> + = public
     * >> - = private
     *
     * Fields  (state)
     * Methods (behavior)
     */

    private String name;
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

    public void meow(){
        System.out.println("meow sound");
    }

    public static void main(String[] args) {
        SimpleCat oscar = new SimpleCat();
        SimpleCat luna = new SimpleCat();
    }
}
