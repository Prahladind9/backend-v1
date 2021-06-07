package edu.prahlad.java.course2.interfaces.looselyCoupled;

public class TaxCalculator2018 implements TaxCalculator{
    private double taxableIncome;

    public TaxCalculator2018(double taxableIncome){ //any change in the constructor param - all implemented classes must be changed
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax(){
        return taxableIncome * 0.3;
    }
}
