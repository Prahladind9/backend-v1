package edu.prahlad.educativeio.recursion.arrays;

public class SortArray {

    public static void sortArray(int[] arr, int n){
        //base case
        if (n==1){
            return;
        }

        for (int i = 0; i < n-1; i++) {
            if (arr[i] > arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }

        sortArray(arr, n-1);
    }

    public static void main(String[] args) {
        System.out.println("Unsorted Array: ");

        int[] array = {40, 24, 60, 15, 10, 45, 93};
        //int[] array = {1,2,2,2,1};

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");

        System.out.println("Sorted Array ASC: ");

        sortArray(array, array.length);

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");
    }
}
