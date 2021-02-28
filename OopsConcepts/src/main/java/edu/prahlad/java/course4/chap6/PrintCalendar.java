package edu.prahlad.java.course4.chap6;

import java.util.Scanner;

public class PrintCalendar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter full year (e.g., 2021): ");
        int year = input.nextInt();

        System.out.println("Enter month as a number between 1 and 12: ");
        int month = input.nextInt();

        printMonth(year, month);
    }

    private static void printMonth(int year, int month) {
        System.out.println(month + " " + year);
    }

    private static void printMonthTitle(int year, int month){

    }

    private static void printMonthBody(int year, int month){

    }
}
