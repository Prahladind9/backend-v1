package edu.prahlad.educativeio.recursion.funda;

public class Square {

    public static void main(String args[]) {
        int input = 6;
        int output = square(input);
        System.out.println("The square of the number " + input + " is: " + output);
    }

    //(n-1)^2 ==> (n^2 - 2n + 1)
    //Recursive method to calculate square of a number
    private static int square(int n) {
        //Base case
        if (n == 0) {
            return 0;
        }
        //Recursive case
        else {
            return square(n - 1) + (2 * n) - 1;
        }
    }
}
