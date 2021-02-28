package edu.prahlad.java.course4.chap8;

import java.util.Scanner;

public class FindNearestPoints {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of points: ");
        int numberOfPoints = input.nextInt();

        //Create an array to store points
        double[][] points = new double[numberOfPoints][2];
        System.out.println("Enter "+ numberOfPoints + " points: ");

        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
    }
}
