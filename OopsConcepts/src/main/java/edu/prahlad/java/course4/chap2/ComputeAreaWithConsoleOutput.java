package edu.prahlad.java.course4.chap2;

import java.util.Scanner;

public class ComputeAreaWithConsoleOutput {
    public static void main(String[] args) {
//        System.out.println("Scientific Notation Example "+ 1.345E+3);
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number of radius");
        double radius = input.nextDouble();

        System.out.println("r`2 == " + Math.pow(radius,2));
        double area = radius * radius * 3.14159;

        System.out.println("The area for the circle of radius "
                + radius + " is "+ area);

    }
}
