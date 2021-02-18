package edu.prahlad.java.course3.lambdas.firstLambda;

public class WellWisher {

    public static void wish(Greeting greeting) {
        greeting.greet();
    }

    public static void main(String[] args) {
        Greeting hindiGreeting = new HindiGreeting();
        hindiGreeting.greet(); //calling the object directly

        Greeting englishGreeting = new EnglishGreeting();
        wish(englishGreeting); //Passing an object of EnglishGreeting

        //we are passing an anonymous class object to the wish method.
        wish(new Greeting() {
                 @Override
                 public void greet() {
                     System.out.println("Hiyo");
                 }
             }
        );

        //Steps to create a lambda
        //Step1 - no need to create an anonymous class of type greeting
        /*wish( public void greet() {
                     System.out.println("Hiyo");
            }
        );*/

        //Step2 - as greeting has only one method - no need to provide the method name
        /*wish(public void() {
            System.out.println("Hiyo");
        });*/

        //Step3 - Compiler understands body doesn't return anything,
        //So, mentioning return type is redundant & can remove the public declaration as well
        wish(
                () -> {
                    System.out.println("Hello");
                }
        );

        wish(() -> System.out.println("Hiyo everyone"));
    }
}
