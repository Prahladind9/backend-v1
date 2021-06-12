package edu.prahlad.java.course2.functionalInterfaces.supplier;

import java.util.function.Supplier;

public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> {return Math.random();};
        Supplier<Double> getRandomSimpler = () -> Math.random();

        System.out.println(getRandom.get());
        System.out.println(getRandomSimpler.get());
    }
}
