package leetcode.learn.DataStructures.ArraysAndString.Array2D;

import DataStructures.Shared.Helper;

import java.util.HashMap;

public class DiagonalTraverseSquare_2Handle {

    //Taking 3/3 matrix the diagonal cover travels the
    // 0,0 = 0,1 = 1,0 = 2,0 = 1,1 = 0,2 = 2,1 = 1,2 = 2,2
    //pattern - diagonal walkthrough
//  00
//          01  10
//          20  11  02
//          12  21
//          22

    public static void main(String[] args) {
        DiagonalTraverseSquare_2Handle diagonalTraverse = new DiagonalTraverseSquare_2Handle();
        int[][] res2 = {
                { 1, 2 },
                { 4, 5 },
                { 7, 8 }
        };

        diagonalTraverse.
                findDiagonalOrder(Helper.getArray(3,3));
    }


    public int[] findDiagonalOrder(int[][] matrix) {

        int row = matrix.length; //3
        int column = matrix[0].length; //3
        int[] result = new int[row * column]; //9

        result[0] = matrix[0][0];
        result[(row * column)-1] = matrix[row-1][column-1];
        //2 elements are already stored

        //remaining 7 elements
        // 2 , 3,  2

        // 3 + 3 = 6 - 1 = 5 - 2 ==> 3 loops
        int loops = row + column -3;

        int rowIndex = 0;
        int columnIndex = 1;
        boolean isDown = true;
        boolean evenLoop = loops%2 == 0? true : false; //false

        HashMap<Integer, Integer[]> hashMap = new HashMap<>();

        for(int i = 1, p=1; i>=0 ;p++){
            if(isDown){
                System.out.print("down  " + i + " --> ");
                for(int k =0; k <= i; k++){
                    rowIndex = p - i +k;
                    rowIndex = Math.min(rowIndex, row-1);
                    if(rowIndex == columnIndex){
                        rowIndex--;
                    }
                    System.out.print(rowIndex+""+columnIndex + " ");
                    columnIndex = columnIndex - 1 > 0? columnIndex -1: 0;
                    columnIndex = Math.min(columnIndex, column-1);
                }
            }else {//up

                System.out.print("up    " + i + " --> ");
                for(int k =0; k <= i; k++){
                    rowIndex = i-k;
                    rowIndex = Math.min(rowIndex, row-1);
                    System.out.print(rowIndex+""+columnIndex + " ");
                    ++columnIndex;
                    columnIndex = Math.min(columnIndex, column-1);
                }
            }
            System.out.println();

            isDown = !isDown;


            if(evenLoop){
                if(p >= loops/2){
                    i--;

                }else {
                    i++;
                }
            }else {
                if(p >= (loops/2 +1)){
                    i--;

                }else {
                    i++;
                }
            }


        }



//        Helper.printIntArray(result);

        return result;
    }


    public int[] findDiagonalOrder2(int[][] matrix) {

        int row = matrix.length; //3
        int column = matrix[0].length; //3
        int[] result = new int[row * column]; //9

        result[0] = matrix[0][0];
        result[(row * column)-1] = matrix[row-1][column-1];
        //2 elements are already stored

        //remaining 7 elements
        // 2 , 3,  2

        // 3 + 3 = 6 - 1 = 5 - 2 ==> 3 loops
        int loops = row + column -3;

        int rowIndex = 0;
        int columnIndex = 1;
        boolean isDown = true;
        boolean evenLoop = loops%2 == 0? true : false; //false

        for(int i = 1, p=1; i>0 ;p++){
            if(isDown){
                System.out.print("down  " + i + " --> ");
                for(int k =0; k <= i; k++){
                    rowIndex = p - i +k;
                    rowIndex = Math.min(rowIndex, row-1);
                    if(rowIndex == columnIndex){
                        rowIndex--;
                    }
                    System.out.print(rowIndex+""+columnIndex + " ");
                    columnIndex = columnIndex - 1 > 0? columnIndex -1: 0;
                    columnIndex = Math.min(columnIndex, column-1);
                }
            }else {//up

                System.out.print("up    " + i + " --> ");
                for(int k =0; k <= i; k++){
                    rowIndex = i-k;
                    rowIndex = Math.min(rowIndex, row-1);
                    System.out.print(rowIndex+""+columnIndex + " ");
                    ++columnIndex;
                    columnIndex = Math.min(columnIndex, column-1);
                }
            }
            System.out.println();

            isDown = !isDown;


            if(evenLoop){
                if(p >= loops/2){
                    i--;

                }else {
                    i++;
                }
            }else {
                if(p >= (loops/2 +1)){
                    i--;
                }else {
                    i++;
                }
            }


        }

//        Helper.printIntArray(result);

        return result;
    }




}
