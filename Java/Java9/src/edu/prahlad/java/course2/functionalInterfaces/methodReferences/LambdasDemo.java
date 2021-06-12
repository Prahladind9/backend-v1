package edu.prahlad.java.course2.functionalInterfaces.methodReferences;

import edu.prahlad.java.course2.functionalInterfaces.lambdaExpression.Printer;

public class LambdasDemo {

    public LambdasDemo() {
    }

    public LambdasDemo(String message) {
    }

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void print(String message){ }

    public void print2(String message){ }

    public static void show1() {
        greet(System.out::println);
        greet(LambdasDemo::print);
    }

    public static void show2() {
        var demo = new LambdasDemo();
        greet(message -> demo.print2(message));
        greet(demo::print2);
    }

    public static void show3() {
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
    }

    public static void main(String[] args) {
        show3();
    }
}
