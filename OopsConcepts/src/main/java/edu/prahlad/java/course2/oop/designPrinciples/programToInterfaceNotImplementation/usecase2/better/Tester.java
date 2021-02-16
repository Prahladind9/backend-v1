package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.better;

public class Tester implements Employee{
    public void testSoftware(){};

    @Override
    public void doWork() {
        testSoftware();
    }
}
