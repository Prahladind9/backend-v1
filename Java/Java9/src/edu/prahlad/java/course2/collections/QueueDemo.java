package edu.prahlad.java.course2.collections;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("c");
        queue.add("a");
        queue.add("b");
        queue.offer("d");
        //b -> a -> c
        System.out.println(queue.peek());
        System.out.println(queue.element());//will throw exception, in case of empty queue
        System.out.println(queue.remove());//will throw exception, in case of empty queue
        System.out.println(queue.poll());
    }
}
