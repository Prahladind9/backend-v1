package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class GameDevCompany extends Company{
    @Override
    public Employee[] getEmployees() {
        return new Employee[]{
                new Designer()
        };
    }
}
