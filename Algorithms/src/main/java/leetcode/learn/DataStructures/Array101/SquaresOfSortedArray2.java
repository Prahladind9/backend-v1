package leetcode.learn.DataStructures.Array101;

public class SquaresOfSortedArray2 {
    public static void main(String[] args) {
        SquaresOfSortedArray2 squaresOfSortedArray = new SquaresOfSortedArray2();

        squaresOfSortedArray.printArray(squaresOfSortedArray.sortedSquares(new int[]{-7,-3,2,3,11}));
    }

    private int[] sortedSquares(int[] array){
        for(int i =0; i < array.length; i++){
            array[i] = array[i] * array[i];
        }
        return mergeSort(array,0, array.length-1);
    }

    private int[] mergeSort(int[] arrayToBeSorted, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex)/2;
            mergeSort(arrayToBeSorted, startIndex, middleIndex);
            mergeSort(arrayToBeSorted, middleIndex + 1, endIndex);

            merge(arrayToBeSorted, startIndex, middleIndex, endIndex);
        }

        return arrayToBeSorted;
    }

    private void merge(int[] arrayToBeSorted, int startIndex, int middleIndex, int endIndex) {
        int leftArrayLength = middleIndex - startIndex + 1;
        int rightArrayLength = endIndex - middleIndex;
        int[] leftArray = new int[leftArrayLength + 1];
        int[] rightArray = new int[rightArrayLength + 1];

        for(int i =0; i < leftArrayLength; i++){
            leftArray[i] = arrayToBeSorted[startIndex + i];
        }

        for(int i =0; i < rightArrayLength; i++){
            rightArray[i] = arrayToBeSorted[middleIndex + 1 + i];
        }

        leftArray[leftArrayLength] = Integer.MAX_VALUE;
        rightArray[rightArrayLength] = Integer.MAX_VALUE;

        int leftPointer = 0;
        int rightPointer = 0;
        for(int index = startIndex; index <= endIndex; index++){
            if(leftArray[leftPointer] < rightArray[rightPointer]){
                arrayToBeSorted[index] = leftArray[leftPointer];
                leftPointer ++;
            }else{
                arrayToBeSorted[index] = rightArray[rightPointer];
                rightPointer ++;
            }

        }

    }

    public void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
    }

}
