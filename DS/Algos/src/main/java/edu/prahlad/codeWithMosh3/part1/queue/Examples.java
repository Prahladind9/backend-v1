package edu.prahlad.codeWithMosh3.part1.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Examples {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);

        Examples.reverse(queue);
        System.out.println(queue);
    }

    public static void reverse(final Queue<Integer> queue){
        final Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }
}
