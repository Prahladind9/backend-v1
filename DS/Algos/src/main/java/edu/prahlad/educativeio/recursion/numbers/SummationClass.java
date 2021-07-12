package edu.prahlad.educativeio.recursion.numbers;

public class SummationClass {
    public static void main(String args[]) {
        int input = 5;
        int sum = sumAll(input);
        System.out.println("The sum of integers from 1 to " + input + " is: " + sum);
    }

    private static int sumAll(int num) {
        if (num == 1) {
            return num;
        } else {
            return num + sumAll(num - 1);
        }
    }
}
