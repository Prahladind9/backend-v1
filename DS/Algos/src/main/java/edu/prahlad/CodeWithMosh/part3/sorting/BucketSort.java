package edu.prahlad.CodeWithMosh.part3.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Time memory trade-off
 * <p>
 * Space: O(n+k)
 * Time:
 * Best     Worst
 * Distribution  O(n)    O(n)
 * Iterating buckets  O(k)    O(k)
 * Sorting  O(1)    O(n^2)
 * Total   O(n+k)  O(n^2)
 */
public class BucketSort {
    public void sort(int[] array, int numberOfBuckets) {
        var i = 0;
        for (var bucket : createBUcket(array, numberOfBuckets)) {
            Collections.sort(bucket);
            for (var item : bucket)
                array[i++] = item;
        }
    }

    private List<List<Integer>> createBUcket(int[] array, int numberOfBuckets) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for (var item : array)
            buckets.get(item / numberOfBuckets).add(item);

        return buckets;
    }
}
