package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class OutsourcingCompany extends Company{
    @Override
    public Employee[] getEmployees() {
        return new Employee[]{
                new Programmer(),
                new Tester()
        };
    }
}
