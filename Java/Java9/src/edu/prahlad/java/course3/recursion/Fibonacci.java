package edu.prahlad.java.course3.recursion;

import java.util.Scanner;

public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers should I print?");
        int input = in.nextInt();
        for(int i = 1;i<=input;i++)
        {
            System.out.print(fibonacci(i)+" ");
        }


    }
    private static int fibonacci(int num)
    {
        if(num == 1 || num == 2)
            return 1;
        return fibonacci(num-1) + fibonacci(num-2);
    }

}
