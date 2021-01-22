package leetcode.learn.DataStructures.Array101;

public class SortArrayByParity {
    public static void main(String[] args) {
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        sortArrayByParity.sortArrayByParity(new int[]{3,1,2,4});
    }

    public int[] sortArrayByParity(int[] A) {
        if (A.length == 1) {
            return A;
        }

        int replaceIndex = 0;
        int evenIndex = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                evenIndex = i;
                if (replaceIndex == evenIndex) {
                    ++replaceIndex;
                } else {
                    int temp = A[replaceIndex];
                    A[replaceIndex] = A[i];
                    A[i] = temp;
                    ++replaceIndex;
                }
            }
        }

        return A;
    }
}
