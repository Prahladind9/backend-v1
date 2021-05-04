package edu.prahlad.udemy.recursion;

public class R_3 {
    //Factorial

    private static final int factorialRecursive(int num){
        if(num == 1)  return 1;
        return num * factorialRecursive(num -1);
    }

    private static final int factorialIterative(int num){
        int total = 1;
        for (int i = num; i > 1; i--) {
            total *= i;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
        System.out.println(factorialIterative(5));
    }
}
