package edu.prahlad.java.loops;

public class NumberRunner {
    public static void main(String[] args) {
        MyNumber number = new MyNumber(9);

        boolean isPrime = number.isPrime();
        System.out.println("isPrime "+isPrime);

        int sum = number.sumUptoN();
        System.out.println("sumUptoN "+sum);

        int sumOfDivisors = number.sumOfDivisors();
        System.out.println("sumOfDivisors "+sumOfDivisors);

        number.printNumberTriangle();

    }
}
