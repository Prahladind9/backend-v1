package edu.prahlad.CodeWithMosh.part1.queue;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

public class ZRunner {

    public static void main(String[] args) {
        //exampleImple();
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(5);
        priorityQueue.add(3);
        priorityQueue.add(6);
        priorityQueue.add(1);
        priorityQueue.add(4);;
        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }

    public static void reverse(final Queue<Integer> queue){
        final Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

    }

    private static void exampleImple() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);
        System.out.println(queue.remove());
        System.out.println(queue);
        ZRunner.reverse(queue);
        System.out.println(queue);

        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q);
        q.enqueue(60);
        q.enqueue(70);
        System.out.println(q);

        QueueWith2Stacks queueWith2Stacks = new QueueWith2Stacks();
        queueWith2Stacks.enqueue(10);
        queueWith2Stacks.enqueue(20);
        queueWith2Stacks.enqueue(30);
        System.out.println(queueWith2Stacks);
        queueWith2Stacks.dequeue();
        System.out.println(queueWith2Stacks);
        System.out.println(queueWith2Stacks.peek());
    }
}
