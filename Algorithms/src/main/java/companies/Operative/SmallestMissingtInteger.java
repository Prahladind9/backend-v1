package companies.Operative;

import java.util.Arrays;

public class SmallestMissingtInteger {
    public static void main(String[] args) {
        SmallestMissingtInteger smallestMissingtInteger = new SmallestMissingtInteger();
//        int[] a = {1, 3, 6, 4, 1, 2};
//        int[] a = {1,  2,3};
        int[] a = {-1,  -3,0};
         System.out.println(smallestMissingtInteger.solution(a));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        //1 Arrays Sort
        //2 Arrays[size-1] < 1 then 1
        //4 const = 1 A[0] = 1 based on i
        //for (int i = 0; i < A.length; i++, const++)
        // A[i] != const
        // return const

        Arrays.sort(A);
        if(A[A.length -1] < 1)
            return 1;

        int val = 1;
        for(int i = 0; i < A.length; i++){
            if(A[i] > val){
                ++val;
                if(A[i] != val)
                    return val;
                if(A[i] == val && i == A.length-1)
                    return ++val;
            }
        }
        return val;
    }
}
