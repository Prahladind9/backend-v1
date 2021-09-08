package edu.prahlad.codeWithMosh2.part1.queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[8];
    private int count;

    public void add(int item) {

        //if empty array resize
        resizeArray();

        //shifting items
        int i = shiftItemsToInsert(item);

        items[i] = item;
        count++;
    }

    private void resizeArray() {
        if (count == items.length) {
            int[] temp = new int[items.length * 2];
            for (int i = 0; i < count; i++) {
                temp[i] = items[i];
            }
        }
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count - 1; i >= 0; i--) {
            if (items[i] > item) {
                items[i + 1] = items[i];
            } else {
                break;
            }
        }
        return i + 1;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
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
        PriorityQueue queue = new PriorityQueue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(5);
        System.out.println(queue);
        System.out.println(queue.remove());
    }
}
