package edu.prahlad.educativeio.recursion.funda;

public class Factorial {
    //Recursive Function
    private static int factorial(int n){
        //Base case
        if(n==1){
            return 1;
        }
        //Recursive case
        else{
            return (n * factorial(n-1));
        }
    }

    private static int factorialIterative(int n) {

        int factorialResult = 1;

        for (int i = 1; i <= n; i++) {
            factorialResult = factorialResult * i;
        }
        return factorialResult;

    }

    public static void main(String[] args) {
        //Calling the main
        int result = factorial(5);
        System.out.println("Factorial Recursive of 5 is: " + result);

        result = factorialIterative(5);
        System.out.println("Factorial Iterative of 5 is: " + result);
    }
}
