package edu.prahlad.java.course3.interfaceMethods.defaultMethods.diamondProblemSolution;

public interface InterfaceA {
    default void printSomething(){
        System.out.println("I am inside A interface - default printSomething()");
    }
}
