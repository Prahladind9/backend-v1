package edu.prahlad.codeWithMosh.part1.queue;

import java.util.Arrays;

//Circular Array
public class ArrayQueue {
    private int[] items;
    private int front;
    private int rear;
    private int count;

    public ArrayQueue(int capacity) {
        this.items = new int[capacity];
    }

    public void enqueue(int item) {
        if (count == items.length)
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (count == 0)
            throw new IllegalStateException();

        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
