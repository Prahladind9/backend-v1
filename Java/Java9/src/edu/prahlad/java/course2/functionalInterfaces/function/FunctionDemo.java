package edu.prahlad.java.course2.functionalInterfaces.function;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        functionBasics();

        // "key:value"
        // first: "key=value"
        // second: "{key=value}"

        Function<String, String> replaceColon
                = str -> str.replace(":", "=");
        Function<String, String> addBraces
                = str -> "{" + str + "}";

        //Declarative Programming
        var result =
                replaceColon
                        .andThen(addBraces)
                        .apply("key:value");
        System.out.println(result);

        var result2 =
                addBraces
                        .compose(replaceColon)
                        .apply("key:value");
        System.out.println(result2);
    }

    private static void functionBasics() {
        Function<String, Integer> map = str -> str.length();
        System.out.println(map.apply("Sky"));
    }
}
