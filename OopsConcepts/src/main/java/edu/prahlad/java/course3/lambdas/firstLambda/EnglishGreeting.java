package edu.prahlad.java.course3.lambdas.firstLambda;

public class EnglishGreeting implements Greeting{

    //Overriding the greet() method from Greeting interface.
    @Override
    public void greet() {
        System.out.println("Good Morning");
    }
}
