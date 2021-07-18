package edu.prahlad.educativeio.recursion.numbers;

/**
 * PrimeNumber
 * A prime number is a number greater than 1,
 * that has only two divisors: 1 and the number itself
 * <p>
 * CompositeNumber
 * Composite numbers are numbers that are not prime;
 * that is, they have divisors other than 111 and itself
 * <p>
 * The numbers 1 and 0 are neither prime nor composite.
 */
public class PrimeNumber {

    public static boolean isPrime(int num, int i) {
        //Base case 1
        if (num < 2) {
            return false;
        }//Base case 2
        else if (i == 1) {
            return true;
        }//Base case 3
        else if (num % i == 0) {
            return false;
        }
        //Recursive case
        else {
            return isPrime(num, i - 1);
        }
    }


    public static void main(String args[]) {
        int input = 13;
        boolean result = isPrime(input, input / 2);

        // Print if the number is prime
        if (result == true) {
            System.out.println(input + " is a prime number");
        }
        // Prints if the number is NOT a prime number
        else {
            System.out.println(input + " is NOT a prime number");
        }
    }
}
