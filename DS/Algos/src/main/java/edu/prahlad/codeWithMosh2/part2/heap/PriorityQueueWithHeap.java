package edu.prahlad.codeWithMosh2.part2.heap;

/**
 * Wrapper around Heap class
 */
public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    public void enqueue(int value){
        heap.insert(value);
    }

    public void dequeue(){
        heap.remove();
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
