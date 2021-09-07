package edu.prahlad.codeWithMosh2.part1.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Actions {

    public static void reverse(final Queue<Integer> queue){
        if(queue.isEmpty())
            throw new IllegalStateException();

        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }

        while (!stack.empty()){
            queue.add(stack.pop());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        reverse(queue);
        System.out.println(queue);
    }
}
