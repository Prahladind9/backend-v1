package edu.prahlad.java.course2.oop.solidPrinciples.openClosedPrinciple.after;

import java.time.LocalDate;

public class Air implements Shipping{
    @Override
    public double getCost(Order order) {
        return 0;
    }

    @Override
    public LocalDate getDate(Order order) {
        return null;
    }
}
