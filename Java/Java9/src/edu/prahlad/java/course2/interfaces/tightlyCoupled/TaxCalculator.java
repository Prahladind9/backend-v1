package edu.prahlad.java.course2.interfaces.tightlyCoupled;

public class TaxCalculator {
    private double taxableIncome;

    public TaxCalculator(double taxableIncome){ //any change in the constructor param - all implemented classes must be changed
        this.taxableIncome = taxableIncome;
    }

    public double calculateTax(){
        return taxableIncome * 0.3; //any change on this logic - all classes must be recompiled
    }
}
