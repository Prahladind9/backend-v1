package edu.prahlad.codeWithMosh3.part1.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue{
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        this.items = new int[capacity];
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();
        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalArgumentException();
        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
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
        q.enqueue(80);
    }

}
