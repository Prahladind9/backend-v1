package edu.prahlad.educativeio.recursion.numbers;

/**
 *
 * Leetcode
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 */
public class PowerClass {
    public static void main(String args[]) {

        int num = 5;
        int pow = 5;
        long result = powerSimple(num, pow);
        System.out.println(num + " power of " + pow + " is: " + result);

        System.out.println(powerComplex(2.1, 3));
        System.out.println(powerComplex(2.1, -234));
    }

    private static long powerSimple(int num, int pow) {
        if (pow == 0) {
            return 1;
        } else {
            return num * powerSimple(num, pow - 1);
        }
    }

    private static double powerComplex(double x, int n) {
        if (n < 0) return 1 / x * powerComplex(1 / x, -(n + 1));
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n % 2 == 0) return powerComplex(powerComplex(x, n / 2), 2);
        else return x * powerComplex(powerComplex(x, n / 2), 2);
    }
}
