package edu.prahlad.java.course3.interfaceMethods.defaultMethods.diamondProblemSolution;

public class Main implements InterfaceA, InterfaceB{


    @Override
    public void printSomething() {
        //Option 1 -> Provide our own implementation
        System.out.println("I am inside Main class - printSomething()");

        //Option 2 -> Use existing implementation from interface A or interface B or both.
        InterfaceA.super.printSomething();
        InterfaceB.super.printSomething();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printSomething();
    }
}
