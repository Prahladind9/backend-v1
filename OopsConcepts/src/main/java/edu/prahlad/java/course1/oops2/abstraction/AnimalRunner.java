package edu.prahlad.java.course1.oops2.abstraction;


abstract class Animal{
    abstract void bark();
}

class Dog extends Animal{
    @Override
    void bark() {
        System.out.println("bow bow");
    }
}

class Cat extends Animal{
    @Override
    void bark() {
        System.out.println("Meow Meow");
    }
}
public class AnimalRunner {

    public static void main(String[] args) {
        //Polymorphism
        Animal[] animals = {new Dog(), new Cat()};

        for (Animal animal: animals){
            animal.bark();
        }
    }
}
