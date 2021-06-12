package edu.prahlad.java.course2.functionalInterfaces.lambdaExpression;

public class LambdasDemo {
    public static String prefix = "-";
    public String prefixx = "-";

    public static void greet(Printer printer) {
        printer.print("Hello World");
    }

    public static void showStep1() {
        greet(new ConsolePrinter());
    }

    public static void showStep2() {
        greet(new Printer() {
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });
    }

    public static void showStep3() {
        greet((String message) -> {
            System.out.println(message);
        });
    }

    public static void showStep4() {
        greet((message) -> {
            System.out.println(message);
        });
    }

    public static void showStep5() {
        greet(message -> System.out.println(message));
    }

    public static void showStep6() {
        String prefix = "-";
        greet(message -> System.out.println(prefix + message));//showStep6 method - local prefix
    }

    public static void showStep7() {
        greet(message -> System.out.println(prefix + message));
    }

    public void showStep8() {
        greet(message -> System.out.println(this.prefixx + message));
    }

    public static void main(String[] args) {
        showStep7();
    }
}
