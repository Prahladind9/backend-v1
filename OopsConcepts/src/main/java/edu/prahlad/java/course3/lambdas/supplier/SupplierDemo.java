package edu.prahlad.java.course3.lambdas.supplier;

import java.util.function.IntSupplier;

public class SupplierDemo {
    public static void main(String[] args) {
        IntSupplier supplier = () -> (int) (Math.random() * 100);
        System.out.println(supplier.getAsInt());
    }
}
