package edu.prahlad.educativeio2.patternsForCodingQuestions.bitwiseXOR;

/**
 * Given a binary matrix representing an image,
 * we want to flip the image horizontally, then invert it.
 *
 * To flip an image horizontally means that each row of the image is reversed.
 * For example, flipping [0, 1, 1] horizontally results in [1, 1, 0].
 *
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
 * For example, inverting [1, 1, 0] results in [0, 0, 1].
 *
 * Time: O(n)
 * Space: O(1)
 */
public class FlipAndInvertImage {


    /**
     * Flip: We can flip the image in place by replacing
     *       ith element from left with
     *       ith element from the right
     *
     * Invert: We can take XOR of each element with 1
     *         if it is 1 then it will become 0 and
     *         if it is 0 then it will become 1
     *
     */
    public static int[][] flipAndInvertImage(int[][] arr) {
        int width = arr[0].length;
        for(int[] row: arr){
            for(int i=0; i < (width + 1)/2; ++i){
                int tmp = row[i] ^ 1;
                row[i] = row[width - 1 - i] ^ 1;
                row[width - 1 - i] = tmp;
            }
        }

        return arr;
    }

    public static void print(int[][] arr) {
        for(int i=0; i < arr.length; i++) {
            for (int j=0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));

        int[][]arr2 = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        print(flipAndInvertImage(arr2));
    }
}
