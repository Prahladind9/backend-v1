package edu.prahlad.codeWithMosh2.part1.queue;


import java.util.Stack;

public class QueueWithTwoStacks  {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    //O(1)
    public void enqueue(int item){
        stack1.add(item);
    }

    //O(n)
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
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

    @Override
    public String toString() {
        return "QueueWithTwoStacks{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.enqueue(40);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
    }

}
