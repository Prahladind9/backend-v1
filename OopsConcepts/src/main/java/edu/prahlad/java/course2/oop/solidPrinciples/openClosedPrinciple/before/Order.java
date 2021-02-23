package edu.prahlad.java.course2.oop.solidPrinciples.openClosedPrinciple.before;

/**
 * You have to change the "Order" class whenever you add
 * a new shipping method to the app
 */
public class Order {
    private int lineItems;
    private int shipping;

    private void getTotal(){ }
    private void getTotalWeight(){ }
    private void getShippingType(String type){ }
    private void getShippingCost(){ }
    private void getShippingDate(){ }

}
