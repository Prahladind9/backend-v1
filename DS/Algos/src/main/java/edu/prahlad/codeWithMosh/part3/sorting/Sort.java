package edu.prahlad.codeWithMosh.part3.sorting;

@FunctionalInterface
public interface Sort {
    void sort(int[] array);

    default void swap(int[] array, int currentIndex, int swapIndex) {
        var temp = array[currentIndex];
        array[currentIndex] = array[swapIndex];
        array[swapIndex] = temp;
    }
}
