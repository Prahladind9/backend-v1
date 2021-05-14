package edu.prahlad.udemy2.tree.priorityQueue;

import java.util.ArrayList;
import java.util.List;

class Node {
    String val;
    int priority;

    public Node(String val) {
        this.val = val;
        this.priority = 5;
    }

    public Node(String val, int priority) {
        this.val = val;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", priority=" + priority +
                '}';
    }
}
/*
Higher the Priority - value will be in top Queue
 */
public class PriorityQueue {
    List<Node> values = new ArrayList<>();

    public void enqueue(final String element, int priority) {
        Node newNode = new Node(element, priority);
        this.values.add(newNode);
        this.bubbleUp();
    }

    private void bubbleUp() {
        int idx = this.values.size() - 1;
        final Node element = this.values.get(idx);
        while (true) {
            int parentIdx = (idx - 1) / 2;
            Node parent = this.values.get(parentIdx);
            if (element.priority <= parent.priority) break;

            this.values.set(parentIdx, element);
            this.values.set(idx, parent);
            idx = parentIdx;

        }
    }

    public Node dequeue() {
        if(this.values.size() == 0) return null;
        Node max = this.values.get(0);
        if(this.values.size() == 1) this.values.remove(0);
        if(this.values.size() > 0){
            Node end = this.values.remove(this.values.size() - 1);
            this.values.set(0, end);
            this.sinkDown();  //SinkDown
        }
        return max;
    }

    private void sinkDown() {
        int idx = 0;
        int length = this.values.size();
        Node element = this.values.get(0);

        while (true) {
            int leftChildIdx = (2 * idx) + 1;
            int rightChildIdx = (2 * idx) + 2;
            Node leftChild = null, rightChild;
            Integer swap = null;

            if (leftChildIdx < length) {
                leftChild = this.values.get(leftChildIdx);
                if (leftChild.priority > element.priority) {
                    swap = leftChildIdx;
                }
            }

            if (rightChildIdx < length) {
                rightChild = this.values.get(rightChildIdx);
                if ((swap == null && rightChild.priority > element.priority) ||
                        (swap != null && rightChild.priority > leftChild.priority)
                ) {
                    swap = rightChildIdx;
                }
            }

            if (swap == null) break;
            this.values.set(idx, this.values.get(swap));
            this.values.set(swap, element);

            idx = swap;
        }
    }

    @Override
    public String toString() {
        return "MaxBinaryHeap{" +
                "values=" + values +
                '}';
    }

    public static void main(String[] args) {
        PriorityQueue maxBinaryHeap = new PriorityQueue();
        maxBinaryHeap.enqueue("common cold", 1);
        maxBinaryHeap.enqueue("gunshot wound", 5);
        maxBinaryHeap.enqueue("accident", 4);
        maxBinaryHeap.enqueue("broken arm", 3);
        maxBinaryHeap.enqueue("high fever", 2);

        System.out.println(maxBinaryHeap);
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap.dequeue());
        System.out.println(maxBinaryHeap);

    }
}
