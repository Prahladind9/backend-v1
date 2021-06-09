package edu.prahlad.java.course2.exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    public void updateName(String name) throws IOException {
        if(name == null)
            throw new IOException();
    }

    public void deposit(float value){
        if(value <= 0)
            throw new IllegalArgumentException();
    }

    public void withdraw(float value) throws InsufficientFundsException {
        if(value > balance)
            throw new InsufficientFundsException();
    }

    public void withdrawExpressCounter(float value) throws AccountException {
        if(value > balance){
            var accountException = new AccountException(new InsufficientFundsException());
            throw accountException;
        }

    }
}
