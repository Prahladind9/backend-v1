package edu.prahlad.java.course2.interfaces.tightlyCoupled;

public class TaxReport {
    private TaxCalculator calculator;
    public TaxReport(){
        calculator = new TaxCalculator(100_000);
    }

    public void show(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
