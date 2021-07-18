package edu.prahlad.educativeio.recursion.arrays;

public class NoOfOccurrences {

    private static int noOfOccurrences(int[] arr, int key, int currentIndex){
        //base case 1
        if(arr.length == currentIndex){
            return 0;
        }else if(arr[currentIndex] == key){
            return 1 + noOfOccurrences(arr, key, ++currentIndex);
        }else {
            return noOfOccurrences(arr, key, ++currentIndex);
        }

    }

    public static void main(String[] args) {
        System.out.print("{");

        int[] array = {2,3,4,1,7,8,3};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("}");

        int key = 3;
        int output = noOfOccurrences(array, key, 0);
        System.out.println("Number of occurrences of " + key + ": "  + output);
    }
}
