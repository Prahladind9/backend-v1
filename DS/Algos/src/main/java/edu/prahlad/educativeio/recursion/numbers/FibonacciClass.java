package edu.prahlad.educativeio.recursion.numbers;

public class FibonacciClass {
    public static void main(String args[]) {
        int input = 5;
        System.out.println("Fibonacci sequence for the first " + input + " elements is:");

        // Loop to print all the fibonacci sequence elements
        int i = 0;
        while (i < input) {
            System.out.print(fibonacci(i) + " ");
            i++;
        }
        System.out.println();

        // Loop to print all the fibonacci sequence elements
        i = 0;
        while (i < input) {
            System.out.print(fibonacciMath(i) + " ");
            i++;
        }
    }

    /**
     * Time : O(2^n)
     * Space: O(n)
     */
    private static int fibonacci(int n) {
        //Base case
        if (n <= 1) {
            return n;
        }
        //Recursive case
        else {
            return (fibonacci(n - 1) + fibonacci(n - 2));
        }
    }

    /**
     * Time : O(1)
     * Space: O(1)
     */
    public static int fibonacciMath(int N) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, N) / Math.sqrt(5));
    }
}
