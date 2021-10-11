package edu.prahlad.codeWithMosh.part3.recursion;

public class Factorial {

    //n! = n * (n-1)!
    public static int factorialRecursion(int n) {
        if (n == 0) return 1; //baseCondition
        return n * factorialRecursion(n - 1);
    }

    //4! = 4 * 3 * 2 * 1
    public static int factorialIteration(int n) {
        var factorial = 1;
        for (int i = n; i > 1; i--) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorialIteration(4));
        System.out.println(factorialRecursion(4));
    }
}
