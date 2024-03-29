package edu.prahlad.educativeio.recursion.arrays;

public class Invert {

    private static void invert(int[] arr, int currentIndex){
        if(currentIndex < arr.length/2){
            // swap array[currentIndex] and array[array.length-1-currentIndex]
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[arr.length-1-currentIndex];
            arr[arr.length-1-currentIndex] = temp;

            invert(arr, ++currentIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println("Before: ");

        int[] array = {1,2,3,4,5,6,7};
        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");

        System.out.println("After: ");

        invert(array, 0);

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("} ");
    }
}
