package leetcode.Monthly.April.One.MaxSubArray;

public class MaxSubArray2 {
    public static void main(String args[]){
        System.out.println(maxSubArray());
    }

    //https://www.baeldung.com/java-maximum-subarray - need to check the O(n)
    private static int maxSubArray(){
        int [] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maxSoFar = 0, maxEndingHere = 0;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxEndingHere + arr[i]){
                startIndex = i;
                maxEndingHere = arr[i];
            }else{
                maxSoFar = maxEndingHere + arr[i];
            }
        }
        System.out.println("Found Maximum Subarray between {} and {} " +  startIndex +  endIndex);
        return maxSoFar;
    }
}
