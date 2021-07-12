package edu.prahlad.educativeio.recursion.funda;

public class CountDigits {


    public static void main(String args[]) {

        int input = 14333220;
        int numDigits = countDigitsRecursive(input);
        System.out.println("Number of digits in " + input + " = " + numDigits);

        numDigits = countDigitsIterative(input);
        System.out.println("Number of digits Iterative in " + input + " = " + numDigits);
    }

    private static int countDigitsRecursive(int num) {
        if (num <= 1) {
            return 1;
        } else {
            return 1 + countDigitsRecursive(num / 10);
        }
    }

    private static int countDigitsIterative(int num) {
        int count = 0;

        while (num > 0) {
            num = num / 10;
            count++;
        }

        return count;
    }
}
