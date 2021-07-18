package edu.prahlad.educativeio.recursion.arrays;

public class Palindrome {

    private static boolean palindrome(int[] arr, int idx){
        //base case
        if(idx == arr.length/2){
            return true;
        }else if(arr[idx] != arr[arr.length-1-idx]){
            return false;
        }else {
            return palindrome(arr, ++idx);
        }
    }

    public static void main(String[] args) {
        System.out.println("Array: ");

//        int[] array = {6,1,8,7,6};
        int[] array = {1,2,2,2,1};

        System.out.print("{ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("} ");

        System.out.println("Is it a palindrome?");

        Boolean result = palindrome(array, 0);
        System.out.println(result);
    }
}
