package edu.prahlad.codeWithMosh.part1.queue;

import java.util.Stack;

/**
 * Insertion - O(1)
 * Removing  - O(n)
 */
public class QueueWith2Stacks {
    private final Stack<Integer> stack1 = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public void enqueue(final int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();

        moveStack1ToStack2();
        return stack2.pop();
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();

        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueWith2Stacks{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }
}
