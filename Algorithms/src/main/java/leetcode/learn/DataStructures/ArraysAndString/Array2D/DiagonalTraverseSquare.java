package leetcode.learn.DataStructures.ArraysAndString.Array2D;

import leetcode.learn.DataStructures.Shared.Helper;

public class DiagonalTraverseSquare {

    //Taking 3/3 matrix the diagonal cover travels the
    // 0,0 = 0,1 = 1,0 = 2,0 = 1,1 = 0,2 = 2,1 = 1,2 = 2,2
    //pattern - diagonal walkthrough
    // 0,0
    // 0,1 = 1,0
    // 2,0 = 1,1 = 0,2
    // 1,2 = 2,1
    // 2,2

//        1,2,4,7,5,3,6,8,9

    //0,0 0,1 0,2
    //1,0 1,1 1,2
    //2,0 2,1 2,2

    //get row and column length
    //result will be row * column length
    //no of loop --> loop ==> row + column - 1

    //mid = m > n?  m : n

    //Loop through with +ve and -ve flag

    // m = 0, n =0, flag = +ve
    //for(i=0; i < loop; i++)
    //if (i ==0) then 0,0
    // -ve
    //if(-ve)
    // ++n
    //

    //if (i == m + n -1) then (m,n)

    public static void main(String[] args) {
        DiagonalTraverseSquare diagonalTraverse = new DiagonalTraverseSquare();
        int[][] res1 = {
                { 1, 2 },
                { 3, 4 }
        };

        int[][] res2 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] res3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };
        //1,2,4,7,5,3,6,8,9
        //1 4 2 7 5 3 8 6 9

        //1 5 2 3 6 8 12 9 7 4 8 10 13 14 11 15
        diagonalTraverse.
                findDiagonalOrder2(Helper.getArray(3,3));
    }

    public int[] findDiagonalOrder(int[][] matrix) {

        //Works perfect for square matrices
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[column * row];

        int mid = row > column ? row : column;
        --mid;
        int loops = row + column - 1;
        boolean flag = true;
        int m = 0;
        int n = 0;
        int counter = 0;

        for (int i = 0; i < loops; i++) {
            flag = !flag;
            if (flag) {
                if (i < mid) {
                    for (m = 0, n = i; m <= i; m++) {
                        result[counter] = matrix[m][n - m];
                        ++counter;
                    }
                }

                if (i == mid) {
                    for (n = i, m = 0; m <= i; m++) {
                        result[counter] = matrix[m][n - m];
                        ++counter;
                    }
                }

                if (i > mid) {
                    for (m = i - mid, n = mid; m <= mid; m++, n--) {
                        result[counter] = matrix[m][n];
                        ++counter;
                    }
                }
            } else {
                if (i < mid) {
                    for (m = 0, n = i; m <= i; m++) {
                        result[counter] = matrix[n - m][m];
                        ++counter;
                    }
                }

                if (i == mid) {
                    for (n = i, m = 0; m <= i; m++) {
                        result[counter] = matrix[n - m][m];
                        ++counter;
                    }
                }

                if (i > mid) {
                    for (m = i - mid, n = mid; m <= mid; m++, n--) {
                        result[counter] = matrix[n][m];
                        ++counter;
                    }
                }

            }


        }

        Helper.printIntArray(result);

        return result;
    }


    public int[] findDiagonalOrder2(int[][] matrix) {

        //Works perfect for square matrices
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[column * row];

        int mid = row > column ? row : column;
        --mid;
        int loops = row + column - 1;
        boolean flag = true;
        int m = 0;
        int n = 0;

        for (int i = 0; i < loops; i++) {
            flag = !flag;
            if (flag) {
                if (i < mid) {
                    for (m = 0, n = i; m <= i; m++) {
                        System.out.print("  " +  m + "" + (n - m) ); //matrix[m][n - m]);
                    }
                    System.out.println();
                }

                if (i == mid) {
                    for (n = i, m = 0; m <= i; m++) {
                        System.out.print("  " +  m + "" + (n-m) ); //matrix[m][n - m]);
                    }
                    System.out.println();
                }

                if (i > mid) {
                    for (m = i - mid, n = mid; m <= mid; m++, n--) {
                        System.out.print("  " +  m + "" + n ); //matrix[m][n]);
                    }System.out.println();
                }
            } else {
                if (i < mid) {
                    for (m = 0, n = i; m <= i; m++) {
                        System.out.print("  " +  (n-m) + "" + m ); //matrix[n - m][m]);
                    }System.out.println();
                }

                if (i == mid) {
                    for (n = i, m = 0; m <= i; m++) {
                        System.out.print("  " + (n-m) + "" + m ); //matrix[n - m][m]);
                    }System.out.println();
                }

                if (i > mid) {
                    for (m = i - mid, n = mid; m <= mid; m++, n--) {
                        System.out.print("  " +  n + "" + m ); //matrix[n][m]);
                    }System.out.println();
                }

            }


        }

//        Helper.printIntArray(result);

        return result;
    }

}
