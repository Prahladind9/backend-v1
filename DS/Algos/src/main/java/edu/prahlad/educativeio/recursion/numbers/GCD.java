package edu.prahlad.educativeio.recursion.numbers;

/**
 * The GCD of two integers is the largest integer,
 * that can fully divide both numbers, without a remainder.
 */
public class GCD {
    public static int gcd(int num1, int num2){
        //Base case
        if(num1 == num2)
            return num1;

        //recursive case
        if(num1 > num2){
            return gcd(num1-num2, num2);
        }else {
            return gcd(num1, num2-num1);
        }
    }

    public static void main(String[] args) {
        System.out.println("GCD: " + gcd(36, 54));
        System.out.println("GCD: " + gcd(56, 42));
    }
}
