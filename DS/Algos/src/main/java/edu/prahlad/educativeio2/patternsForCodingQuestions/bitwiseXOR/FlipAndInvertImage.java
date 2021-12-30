package edu.prahlad.educativeio2.patternsForCodingQuestions.bitwiseXOR;

/**
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
