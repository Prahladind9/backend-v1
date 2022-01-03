package edu.prahlad.codeWithMosh3.part2.heap;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int item) {
        if (isFull())
            throw new IllegalStateException();

        items[size++] = item;
        bubbleUp();
    }

    private boolean isFull() {
        return items.length == size;
    }


    private void bubbleUp() {
        int index = size;
        while (index > 0 && items[index] > items[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(25);
        System.out.println(heap);
        //heap.remove();
        System.out.println(heap);
    }

}
