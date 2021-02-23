package edu.prahlad.java.course2.oop.solidPrinciples.openClosedPrinciple.after;

import java.time.LocalDate;

public interface Shipping {
    double getCost(Order order);
    LocalDate getDate(Order order);
}
