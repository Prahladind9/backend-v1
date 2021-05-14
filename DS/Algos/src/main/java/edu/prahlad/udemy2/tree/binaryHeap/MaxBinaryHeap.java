package edu.prahlad.udemy2.tree.binaryHeap;

import java.util.ArrayList;
import java.util.List;

/*
Insertion & Removal - O(log(n))
Search - O(n)
 */
public class MaxBinaryHeap {
    List<Integer> values = new ArrayList<>();

    public void insert(final Integer element) {
        this.values.add(element);
        this.bubbleUp();
    }

    private void bubbleUp() {
        int idx = this.values.size() - 1;
        final Integer element = this.values.get(idx);
        while (true) {
            int parentIdx = (idx - 1) / 2;
            Integer parent = this.values.get(parentIdx);
            if (element <= parent) break;

            this.values.set(parentIdx, element);
            this.values.set(idx, parent);
            idx = parentIdx;

        }
    }

    public Integer extractMax() {
        if(this.values.size() == 0) return null;
        Integer max = this.values.get(0);
        if(this.values.size() == 1) this.values.remove(0);
        Integer end = this.values.remove(this.values.size() - 1);
        if(this.values.size() > 0){
            this.values.set(0, end);
            this.sinkDown();  //SinkDown
        }
        return max;
    }

    private void sinkDown() {
        int idx = 0;
        int length = this.values.size();
        int element = this.values.get(0);

        while (true) {
            int leftChildIdx = (2 * idx) + 1;
            int rightChildIdx = (2 * idx) + 2;
            int leftChild = Integer.MIN_VALUE, rightChild = Integer.MIN_VALUE;
            Integer swap = null;

            if (leftChildIdx < length) {
                leftChild = this.values.get(leftChildIdx);
                if (leftChild > element) {
                    swap = leftChildIdx;
                }
            }

            if (rightChildIdx < length) {
                rightChild = this.values.get(rightChildIdx);
                if ((swap == null && rightChild > element) ||
                        (swap != null && rightChild > leftChild)
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
        MaxBinaryHeap maxBinaryHeap = new MaxBinaryHeap();
        maxBinaryHeap.insert(41);
        maxBinaryHeap.insert(39);
        maxBinaryHeap.insert(33);
        maxBinaryHeap.insert(18);
        maxBinaryHeap.insert(27);
        maxBinaryHeap.insert(12);
        maxBinaryHeap.insert(55);

        System.out.println(maxBinaryHeap);
        System.out.println(maxBinaryHeap.extractMax());
        System.out.println(maxBinaryHeap);

        maxBinaryHeap.insert(99);
        maxBinaryHeap.insert(1);
        System.out.println(maxBinaryHeap);

    }
}
