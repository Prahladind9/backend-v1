package edu.prahlad.java.loops;

public class MyNumber {
    private int number;
    public MyNumber(int number) {
        this.number = number;
    }

    public boolean isPrime() {

        //Guard Condition
        if(number <2){
            return false;
        }

        for(int i = 2; i <= number-1; i++){
            if (number%i ==0){
                return false;
            }
        }
        return true;
    }

    public int sumUptoN() {
        int sum = 0;
        for(int i=1; i <=number; i++){
            sum = sum+i;
        }
        return sum;
    }

    public int sumOfDivisors() {
        int sum = 0;
        for(int i=2; i <= number-1; i++) {
            if (number % i == 0){
                sum = sum + i;
            }
        }
        return sum;
    }

    public void printNumberTriangle() {
        for(int i=1; i<=number; i++){
            for(int k=1;k <= i; k++) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
