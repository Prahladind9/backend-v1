package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class Designer implements Employee {
    public void designArchitecture(){
        System.out.println("Designer - designArchitecture");
    }

    @Override
    public void doWork() {
        System.out.println("Designer - doWork Call");
        designArchitecture();
    }
}
