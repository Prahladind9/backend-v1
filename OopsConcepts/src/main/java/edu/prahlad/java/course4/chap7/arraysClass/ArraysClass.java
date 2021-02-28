package edu.prahlad.java.course4.chap7.arraysClass;

public class ArraysClass {
    public static void main(String[] args) {
        double[] numbers = {6.0, 4.4, 1.9, 2.9, 3.4, 3.5};
        java.util.Arrays.sort(numbers); // Sort the whole array
        java.util.Arrays.parallelSort(numbers); // Sort the whole array

        char[] chars = {'a', 'A', '4', 'F', 'D', 'P'};
        java.util.Arrays.sort(chars, 1, 3); // Sort part of the array
        java.util.Arrays.parallelSort(chars, 1, 3); // Sort part of the array


        int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
        System.out.println("1. Index is " +
                java.util.Arrays.binarySearch(list, 11));
        System.out.println("2. Index is " +
                java.util.Arrays.binarySearch(list, 12));

        char[] chars2 = {'a', 'c', 'g', 'x', 'y', 'z'};
        System.out.println("3. Index is " +
                java.util.Arrays.binarySearch(chars2, 'a'));
        System.out.println("4. Index is " +
                java.util.Arrays.binarySearch(chars2, 't'));


        int[] list1 = {2, 4, 7, 10};
        int[] list2 = {2, 4, 7, 10};
        int[] list3 = {4, 2, 7, 10};
        System.out.println(java.util.Arrays.equals(list1, list2)); // true
        System.out.println(java.util.Arrays.equals(list2, list3)); // false

        java.util.Arrays.fill(list1, 5); // Fill 5 to the whole array
        java.util.Arrays.fill(list2, 1, 5, 8); // Fill 8 to a partial array

    }
}
