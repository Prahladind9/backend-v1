package edu.prahlad.java.course3.lambdas.supplier;

import java.util.function.DoubleSupplier;

public class SupplierDemo2 {
    public static void main(String[] args) {
        DoubleSupplier supplier = () -> (int)(Math.random() * 10);
        System.out.println(supplier.getAsDouble());
    }
}
