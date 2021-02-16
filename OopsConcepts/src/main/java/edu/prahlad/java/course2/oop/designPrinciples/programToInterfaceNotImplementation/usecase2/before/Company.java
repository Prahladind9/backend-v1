package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.before;

/**
 * All classes are tightly coupled
 */
public class Company {
    public void createSoftware(){
        Designer designer = new Designer();
        designer.designArchitecture();

        Programmer programmer = new Programmer();
        programmer.writeCode();

        Tester t = new Tester();
        t.testSoftware();
    }
}
