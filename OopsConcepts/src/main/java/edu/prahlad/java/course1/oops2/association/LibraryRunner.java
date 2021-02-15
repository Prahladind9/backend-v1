package edu.prahlad.java.course1.oops2.association;

class Member {
    protected String name;
    // Add the missing member variable
    protected double amountOverDue;
    protected OverdueFee overdueFee;

    public double getAmountOverDue() {
        // Add function logic
        return overdueFee.amount - ((overdueFee.amount * overdueFee.discountPercentage ) / 100);
    }

    public void setAmountOverDue(double amount, double discountPercentage) {
        // Add function logic
        overdueFee = new OverdueFee(amount, discountPercentage);
    }
}

class OverdueFee {

    protected double discountPercentage;
    protected double amount;

    public OverdueFee(double amount, double discountPercentage) {
        this.amount = amount;
        this.discountPercentage = discountPercentage;
    }

}
public class LibraryRunner {
}
