package edu.prahlad.java.course2.oop.designPrinciples.encapsulateWhatVaries.OnMethodLevel;

/**
 * Before: tax calculation code is mixed with the rest if the method's code.
 */
public class EncapsulateOnMethodLevel {

    public static double getOrderTotal(Order order){
        double total = 0.0;

        for (Item item: order.items){
            total += item.price * item.quantity;
        }

        if(order.country == "US"){
            total += total * 0.07; //US sales tax
        }else if(order.country == "EU"){
            total += total * 0.27; //EU sales tax
        }else {

        }
        return total;
    }
}
