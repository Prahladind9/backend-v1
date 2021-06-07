package edu.prahlad.java.course2.interfaces.looselyCoupled;

public class ZRunner {
    public static void main(String[] args) {
        var calculator = new TaxCalculator2018(10_100);

        //Constructor Injection
        var report = new TaxReport(calculator);
        report.show();

        //Setter Injection
        report.setCalculator(new TaxCalculator2019());
        report.show();

        //Method Injection
        report = new TaxReport();
        report.show(new TaxCalculator2019());

    }
}
