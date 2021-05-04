package edu.prahlad.udemy.recursion;

public class R_2 {
    private static final int sumRange(int num){
        if(num ==1) return 1;
        return num + sumRange(num-1);
    }

    public static void main(String[] args) {
        System.out.println(sumRange(3));
        System.out.println(sumRange(10));
    }
}
