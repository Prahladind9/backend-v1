package edu.prahlad.educativeio.recursion.numbers;

public class DecimalToBinary {

    public static int decimalToBinary(int decimalNum){
        if(decimalNum == 0){
            return 0;
        }else {
            return (decimalNum % 2 + 10 * decimalToBinary(decimalNum/2));
        }
    }

    public static void main( String args[] ) {
        int input = 29;
        int result = decimalToBinary(input);
        System.out.println("The binary form of " + input + " is: " + result);
    }
}