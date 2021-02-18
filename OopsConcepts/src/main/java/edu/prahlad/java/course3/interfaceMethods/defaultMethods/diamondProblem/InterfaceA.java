package edu.prahlad.java.course3.interfaceMethods.defaultMethods.diamondProblem;

public interface InterfaceA {
    default void printSomething(){
        System.out.println("I am inside A interface");
    }
}
