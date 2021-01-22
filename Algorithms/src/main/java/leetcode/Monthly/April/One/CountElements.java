package leetcode.Monthly.April.One;

import java.util.HashSet;

public class CountElements {
    public static int countElements(int[] arr) {
        HashSet hashSet = new HashSet();
        int counter = 0;
        for(int a: arr){
            hashSet.add(a);
        }
        for (int j = 0; j < arr.length; j++) {
            if(hashSet.contains(arr[j]+ 1)){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
            countElements(new int[]{1,3,2,3,5,0});
    }


}
