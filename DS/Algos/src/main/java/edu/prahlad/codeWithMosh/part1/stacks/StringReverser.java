package edu.prahlad.codeWithMosh.part1.stacks;
import java.util.Stack;

public class StringReverser {
    public String reverse(String input){
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        for(char ch: input.toCharArray())
            stack.push(ch);

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty())
            stringBuffer.append(stack.pop());

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        StringReverser stringReverser = new StringReverser();
        System.out.println(stringReverser.reverse("Hello"));
    }
}
