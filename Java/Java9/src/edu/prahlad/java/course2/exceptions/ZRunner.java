package edu.prahlad.java.course2.exceptions;

import java.io.IOException;

public class ZRunner {
    public static void main(String[] args) {
        ExceptionsDemo.throwNullPointer();
        ExceptionsDemo.showFile();
        ExceptionsDemo.handleShowFile();

        var account = new Account();
        //account.deposit(-1);
        account.deposit(1);

        try {
            account.updateName(null);
        } catch (IOException e) {
            System.out.println("Logging.");
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");
        }

        try {
            account.withdraw(10);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            account.withdrawExpressCounter(10_000);
        } catch (AccountException e) {
            var cause = e.getCause();
            System.out.println("cause: " + cause.getMessage());
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}
