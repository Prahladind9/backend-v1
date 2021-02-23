package edu.prahlad.java.course2.oop.solidPrinciples.openClosedPrinciple.after;

import java.time.LocalDate;

public class Ground implements Shipping{
    @Override
    public double getCost(Order order) {
        //Free ground delivery on big orders.
        if(order.getTotal() > 100)
            return 0.0;

        //1.5$ per kg, but $10 minimum
        return Math.max(10, order.getTotalWeight() * 1.5);
    }

    @Override
    public LocalDate getDate(Order order) {
        return LocalDate.now();
    }
}
