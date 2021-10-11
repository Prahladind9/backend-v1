package edu.prahlad.codeWithMosh.part3.searching;

public class ZSearchRunner {
    public static void main(String[] args) {
        final var search = new Search();
        final int[] numbers = {8, 1, 3, 5, 6, 19};
        System.out.println(search.linearSearch(numbers, 3));

        final int[] sortedNumbers = {1, 3, 5, 6, 19};
        System.out.println(search.binarySearch(sortedNumbers, 6));
        System.out.println(search.binarySearchRec(sortedNumbers, 19));
        System.out.println(search.ternarySearch(sortedNumbers, 19));
        System.out.println(search.jumpSearch(sortedNumbers, 29));
        System.out.println(search.exponentialSearch(sortedNumbers, 5));
    }
}
