package edu.prahlad.java.oops;

import java.math.BigDecimal;
import java.util.Scanner;

public class MenuRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number1: ");
        int number1 = scanner.nextInt();
        System.out.println("The number you entered is - "+ number1);

        BigDecimal bigDecimal = new BigDecimal("33");
    }
}


class Test implements Comparable<String>{
    @Override
    public int compareTo(String o) {
        return 0;
    }
}
