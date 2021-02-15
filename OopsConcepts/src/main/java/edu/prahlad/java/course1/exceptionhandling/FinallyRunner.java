package edu.prahlad.java.course1.exceptionhandling;

import java.util.Scanner;

public class FinallyRunner {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in);) {
            int[] numbers = {12, 3, 4, 6};
            int num = numbers[5];

        }catch (Exception e){
            //System.exit(1);
            e.printStackTrace();
        } finally {
            System.out.println("Before Scanner close");
        }

        System.out.println("Just before closing out main");

        /**
         * A line in finally will not be executed, only if
         * 1) code in finally block throws error
         * 2) JVM crashes > example on call of System.exit(1);
         */

        /**
         * try() - try with resource ... will compile without catch or finally
         * try   - plain try must have catch or finally - else compiler error
         */
    }
}
