package edu.prahlad.java.course1.oops;

public class BookRunner {
    public static void main(String[] args) {
        Book artOfComputerProgramming = new Book(1000);
        Book effectiveJava = new Book(1000);
        Book cleanCode = new Book(1000);

        artOfComputerProgramming.setNoOfCopies(100);
        effectiveJava.setNoOfCopies(50);
        cleanCode.setNoOfCopies(45);

        cleanCode.increaseNoOfCopies(10);
        cleanCode.decreaseNoOfCopies(5);
    }
}
