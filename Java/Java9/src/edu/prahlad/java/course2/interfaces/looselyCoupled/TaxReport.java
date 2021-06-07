package edu.prahlad.java.course2.interfaces.looselyCoupled;

public class TaxReport {
    private TaxCalculator calculator;
    public TaxReport(){
        //calculator = new TaxCalculator2018(100_000);
    }

    //Loose coupling
    //Constructor Injection
    public TaxReport(TaxCalculator calculator){
        this.calculator = calculator;
    }

    //We can the dependency of class, throughout the lifetime
    //Setter Injection
    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    //
    //Method Injection
    public void show(TaxCalculator calculator){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    public void show(){
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

}
