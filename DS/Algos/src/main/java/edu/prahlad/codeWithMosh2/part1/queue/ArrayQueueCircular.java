package edu.prahlad.codeWithMosh2.part1.queue;

import java.util.Arrays;

public class ArrayQueueCircular {

    private int[] items;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueueCircular(int size) {
        this.items = new int[size];
    }

    public void enqueue(int item) {
        if (count == items.length) {
            int[] temp = new int[this.items.length * 2];
            for (int i = 0; i < this.items.length; i++) {
                temp[i] = this.items[i];
            }
            this.items = temp;
        }

        this.items[rear] = item;
        rear = (rear + 1) % items.length;
        count++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        var item = this.items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        count--;
        return item;

    }

    public int peek() {
        return this.items[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == this.items.length;
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
        ArrayQueueCircular arrayQueue = new ArrayQueueCircular(3);
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.enqueue(10);
        arrayQueue.enqueue(40);
        arrayQueue.enqueue(50);
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
