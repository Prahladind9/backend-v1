package edu.prahlad.java.course3.interfaceMethods.functionalInterface;

@FunctionalInterface
public interface Functional {

    //if there is not even single abstract method,
    // then as well we'll get compilation error.
    void doSomething();

    //if we add another abstract method,
    // "@FunctionalInterface rule" gets violated & we'll get compilation error.
    //void doSomethingDifferent();

    default void foo() {
        System.out.println("foo");
    }
}
