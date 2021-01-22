package leetcode.learn.DataStructures.Shared;

public class Helper {

    public static void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }


    public static void printStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

    public static int[][] getArray(int row, int column){
        int[][] array = new int[row][column];
        int value=0;
        for(int i = 0; i < row; i++, value++){
            for(int k = 0; k < column; k++, value++){
                array[i][k] = value;
            }
        }

        return array;
    }
}
