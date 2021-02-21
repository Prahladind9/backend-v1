package edu.prahlad.java.course4.chap2;

import java.util.Scanner;

/**
 * Number Type Conversions
 * Floating-point numbers can be converted into integers using explicit casting.
 */
public class SalesTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter purchase amount: ");
        double purchaseAmount = input.nextDouble();

        double tax = purchaseAmount * 0.06;
        System.out.println("Sales tax in $" + (tax));
        System.out.println("Sales tax in $" + (int) (tax));
        System.out.println("Sales tax in $" + (int) (tax * 100)/100.0);

        //line#   purchaseAmount    tax         Output
        // 8        197.55
        //10                        11.853
        //11                                    11.85
    }
}
