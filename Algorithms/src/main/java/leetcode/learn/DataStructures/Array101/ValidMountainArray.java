package leetcode.learn.DataStructures.Array101;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
 */
public class ValidMountainArray {
    public static void main(String[] args) {
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public boolean validMountainArray(int[] A) {

        //walk up to the top of the mountain and walk down
        // if already at peak or reached the max mountain ... then false

        int N = A.length;
        int i = 0;

        // walk up
        while (i+1 < N && A[i] < A[i+1])
            i++;

        // peak can't be first or last
        if (i == 0 || i == N-1)
            return false;

        // walk down
        while (i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;
    }

    public boolean validMountainArray2(int[] A) {

        int N = A.length;
        int i =0;

        while(i+1 < N && A[i] < A[i+1])
            i++;

        if(i ==0 || i == N-1)
            return false;

        while(i+1 < N && A[i] > A[i+1])
            i++;

        return i == N-1;

    }


    public boolean validMountainArray3(int[] A) {
        boolean positive = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] > A[i]) {
                positive = true;
            } else if (A[i + 1] < A[i]) {
                positive = false;
            } else {
                positive = true;
            }
        }

        if (positive == false) {
            return true;
        } else {
            return false;
        }

    }
}
