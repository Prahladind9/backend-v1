package edu.prahlad.codeWithMosh2.part1.queue;

import java.util.Arrays;

public class ArrayQueue {

    private int[] items;
    private int front = 0;
    private int rear = 0;

    public ArrayQueue(int size) {
        this.items = new int[size];
    }

    public void enqueue(int val) {
        if (isFull()) {
            int[] temp = new int[this.items.length * 2];
            for (int i = 0; i < this.items.length; i++) {
                temp[i] = this.items[i];
            }
            this.items = temp;
        }

        this.items[rear++] = val;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = this.items[front];
        items[front++] = 0;
        return item;

    }

    public int peek() {
        return this.items[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return rear == this.items.length;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "data=" + Arrays.toString(items) +
                ", F=" + front +
                ", R=" + (rear - 1) +
                '}';
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.enqueue(10);
        System.out.println(arrayQueue.isFull());
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.enqueue(20);
        System.out.println(arrayQueue);
        System.out.println("peek " + arrayQueue.peek());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        //System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.isEmpty());

    }
}
