package edu.prahlad.codeWithMosh3.part1.queue;

import java.util.Arrays;

/**
 * PriorityQueue - value will be sorted as per Integer Order
 *
 * Add/enqueue - O(n)
 * remove - O(1)
 */
public class PriorityQueue implements Queue{
    private int[] items;
    private int count;

    public PriorityQueue(int capacity) {
        this.items = new int[capacity];
    }

    @Override
    public void enqueue(int item) {
        if (isFull())
            throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        items[i] = item;
        count++;
    }

    public int shiftItemsToInsert(int item){
        int i;
        for (i = count -1; i >=0; i--) {
            if(items[i] > item){
                items[i+1] = items[i];
            }else{
                break;
            }
        }
        return i+1;
    }

    @Override
    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }


    private boolean isEmpty() {
        return count == 0;
    }

    private boolean isFull() {
        return count == items.length;
    }

    @Override
    public String toString() {
        return "PriorityQueue{" +
                "items=" + Arrays.toString(items) +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(5);
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(6);
        queue.enqueue(1);
        queue.enqueue(12);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        queue.enqueue(61);
        System.out.println(queue);

        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
