package edu.prahlad.codeWithMosh3.part1.queue;

import java.util.Stack;

/**
 * Inserting O(1)
 * Deleting O(n)
 */
public class QueueWithStacks implements Queue{
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    @Override
    public void enqueue(int item) {
        stack1.add(item);
    }

    @Override
    public int dequeue() {
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return stack2.pop();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty())
                stack2.add(stack1.pop());
        }
    }

    private boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return "QueueWithStacks{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public static void main(String[] args) {
        QueueWithStacks queueWith2Stacks = new QueueWithStacks();
        queueWith2Stacks.enqueue(10);
        queueWith2Stacks.enqueue(20);
        queueWith2Stacks.enqueue(30);
        System.out.println(queueWith2Stacks);
        queueWith2Stacks.dequeue();
        System.out.println(queueWith2Stacks);
        System.out.println(queueWith2Stacks.peek());
    }

}
