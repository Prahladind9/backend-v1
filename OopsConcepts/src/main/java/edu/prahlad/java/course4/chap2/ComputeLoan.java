package edu.prahlad.java.course4.chap2;

import java.util.Scanner;

public class ComputeLoan {
    public static void main(String[] args) {
        //Create a Scanner
        Scanner input = new Scanner(System.in);

        int value = 2147483647 +1;
        //Enter annual interest rate in percentage, e.g., 7.25
        System.out.print("Enter annual interest rate, e.g., 7.25: ");
        double annualInterestRate = input.nextDouble();

        //Obtain monthly interest rate
        double monthlyInterestRate = annualInterestRate / 1200;
        System.out.println("monthlyInterestRate "+monthlyInterestRate);

        //Enter number of years
        System.out.print("Enter number of years as an integer, e.g., 5: ");
        int numberOfYears = input.nextInt();
        System.out.println("numberOfYears "+numberOfYears);

        //Enter loan Amount
        System.out.print("Enter loan Amount, e.g., 120000.95: ");
        double loanAmount = input.nextDouble();
        System.out.println("loanAmount "+loanAmount);

        //Calculate payment
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - (1/Math.pow(1+monthlyInterestRate, numberOfYears * 12)));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        //Display results
        System.out.println("The monthly payment is $"+ (int) (monthlyPayment * 100)/100.0);
        System.out.println("The total payment is $"+ (int) (totalPayment * 100)/100.0);
    }
}
