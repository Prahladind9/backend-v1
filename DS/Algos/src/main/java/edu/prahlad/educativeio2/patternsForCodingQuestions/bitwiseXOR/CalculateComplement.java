package edu.prahlad.educativeio2.patternsForCodingQuestions.bitwiseXOR;

/**
 *
 * Every non-negative integer N has a binary representation, for example,
 * 8 can be represented as “1000” in binary and 7 as “0111” in binary.
 *
 * The complement of a binary representation is the number in binary
 * that we get when we change every 1 to a 0 and every 0 to a 1.
 * For example, the binary complement of “1010” is “0101”.
 *
 * For a given positive number N in base-10,
 * return the complement of its binary representation as a base-10 integer.
 *
 * Time O(b)
 * Space O(1)
 */
public class CalculateComplement {
    public static int bitwiseComplement(int num) {
        int bitCount = 0;
        int n = num;
        while(n >0){
            bitCount++;
            n = n >> 1;
        }

        int all_bits_set = (int) Math.pow(2, bitCount)-1;
        return num ^ all_bits_set;
    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}