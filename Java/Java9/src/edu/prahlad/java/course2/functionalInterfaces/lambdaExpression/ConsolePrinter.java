package edu.prahlad.java.course2.functionalInterfaces.lambdaExpression;

public class ConsolePrinter implements Printer{
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
