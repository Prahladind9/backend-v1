package edu.prahlad.java.course2.oop.designPrinciples.encapsulateWhatVaries.OnMethodLevel;

/**
 * After: you can get the tax rate by calling a designated method
 */
public class EncapsulateOnMethodLevel2 {

    public static double getOrderTotal(Order order){
        double total = 0.0;

        for (Item item: order.items){
            total += item.price * item.quantity;
        }

        total += total * getTaxRate(order.country);
        return total;
    }

    private static double getTaxRate(String country) {
        if(country == "US"){
            return 0.07; //US sales tax
        }else if(country == "EU"){
            return  0.27; //EU sales tax
        }else {
            return 0.0;
        }
    }
}
