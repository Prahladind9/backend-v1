package edu.prahlad.java.course2.oop.designPrinciples.programToInterfaceNotImplementation.usecase2.after;

public class Driver {
    public static void main(String[] args) {
        Company outsourcingCompany = new OutsourcingCompany();
        outsourcingCompany.createSoftware();

        System.out.println("------------------------------------");

        Company gameDevCompany = new GameDevCompany();
        gameDevCompany.createSoftware();
    }
}
