package edu.prahlad.educativeio.recursion.numbers;

public class ModuloClass {

    public static void main(String args[]) {
        int dividend = 27;
        int divisor = 2;
        int remainder = mod(dividend, divisor);
        System.out.println(dividend + " mod " + divisor + " = " + remainder);
    }

    public static int mod(int dividend, int divisor) {
        //Making sure there is no division by 0
        if (divisor == 0) {
            System.out.println("Divisor cannot be 0");
            return -1;
        }

        //Base case
        if (dividend < divisor) {
            return dividend;
        } else {
            return mod(dividend - divisor, divisor);
        }
    }
}