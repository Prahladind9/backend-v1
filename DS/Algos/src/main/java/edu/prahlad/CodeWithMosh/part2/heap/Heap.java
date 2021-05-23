package edu.prahlad.CodeWithMosh.part2.heap;

import java.util.Arrays;

public class Heap {
    private int[] items = new int[10]; //can be initialized later with constructor
    private int size;

    public void insert(int item) {
        if (isFull()) throw new IllegalStateException();
        this.items[size++] = item;
        //newItem > parent => bubble up
        bubbleUp();
    }

    public void remove() {
        if (isEmpty()) throw new IllegalStateException();

        items[0] = items[--size];
        //item(root) < children => bubble Down

        var index = 0;
        while (index <= size && !isValidParent(index)) {
            var largerChildIndex = largerChildIndex(index);
            swap(index, largerChildIndex(index));
            index = largerChildIndex;
        }
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index) {
        return (leftChild(index) > rightChild(index))
                ? leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        return items[index] >= leftChild(index) &&
                items[index] >= rightChild(index);
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    public boolean isFull() {
        return items.length == size;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public int max(){
        if(isEmpty()) throw new IllegalStateException();
        return items[0];
    }

    @Override
    public String toString() {
        return "Heap{" +
                "items=" + Arrays.toString(items) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(25);
        System.out.println(heap);
        heap.remove();
        System.out.println(heap);
    }
}
