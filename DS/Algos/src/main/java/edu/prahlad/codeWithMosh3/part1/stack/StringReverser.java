package edu.prahlad.codeWithMosh3.part1.stack;

import java.util.Stack;

public class StringReverser {

    public String reverse(String input){
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();

        for (char ch: input.toCharArray())
            stack.add(ch);

        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty()){
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.reverse("Hello"));
        //System.out.println(stringReverser.reverse(null));
    }
}
