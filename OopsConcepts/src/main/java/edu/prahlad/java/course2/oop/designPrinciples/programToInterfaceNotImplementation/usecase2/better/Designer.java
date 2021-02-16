package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.better;

public class Designer implements Employee{
    public void designArchitecture(){}

    @Override
    public void doWork() {
        designArchitecture();
    }
}
