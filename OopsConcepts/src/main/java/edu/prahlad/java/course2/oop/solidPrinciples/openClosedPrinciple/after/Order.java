package edu.prahlad.java.course2.oop.solidPrinciples.openClosedPrinciple.after;

import java.time.LocalDate;

/**
 * After: adding a new shipping method doesn't require
 * chaining existing classes
 */
public class Order {
    private double total;
    private double totalWeight;
    private int lineItems;
    private Shipping shipping;

    public double getTotal(){
        return total;
    }
    public double getTotalWeight(){
        return totalWeight;
    }
    public String getShippingType(String type){
        return type;
    }
    public double getShippingCost(){
        return shipping.getCost(this);
    }
    public LocalDate getShippingDate(){
        return shipping.getDate(this);
    }
}
