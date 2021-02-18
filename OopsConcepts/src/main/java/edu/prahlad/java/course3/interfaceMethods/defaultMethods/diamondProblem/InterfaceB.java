package edu.prahlad.java.course3.interfaceMethods.defaultMethods.diamondProblem;

public interface InterfaceB {
    default void printSomething(){
        System.out.println("I am inside B interface");
    }
}
