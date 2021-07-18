package edu.prahlad.educativeio.recursion.arrays;

public class FirstOccurrence {

    private static int firstOccurrence(int[] arr, int num, int currentIndex){
        //base case 1
        if(arr.length == currentIndex){
            return -1;
        }
        //base case 2
        else if(arr[currentIndex] == num){
            return currentIndex;
        }else {
            return firstOccurrence(arr, num, currentIndex+1);
        }
    }

    public static void main(String[] args) {
        System.out.print("{");

        int[] array = {2,3,4,1,7,8,3};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("}");

        int num = 3;

        int result = firstOccurrence(array, num, 0);
        System.out.println("The first occurrence of the number " + num + " is at index: " + result);
    }
}
