package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class Tester implements Employee {
    public void testSoftware(){
        System.out.println("Tester - testSoftware");
    };

    @Override
    public void doWork() {

        System.out.println("Tester - doWork Call");
        testSoftware();
    }
}
