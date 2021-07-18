package edu.prahlad.educativeio.recursion.arrays;

public class ReplaceNegativeValues {

    private static void replaceNegativeValues(int[] arr, int currentIndex){
        if(currentIndex == arr.length){
            return;
        }else {
            if(arr[currentIndex] < 0)
                arr[currentIndex] = 0;

            replaceNegativeValues(arr, ++currentIndex);
        }
    }


    public static void main(String[] args) {
        System.out.println("Before: ");

        int[] array = {2,-3,4,-1,-7,8,3};

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("} ");
        System.out.println("After: ");

        replaceNegativeValues(array, 0);

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.print("} ");
    }
}
