package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class Programmer implements Employee {
    public void writeCode() {
        System.out.println("Programmer - writeCode");
    }

    @Override
    public void doWork() {
        System.out.println("Programmer - doWork Call");
        writeCode();
    }
}
