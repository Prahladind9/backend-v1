package leetcode.Monthly.April.One.MaxSubArray;

public class MaxSubArray {
    public static void main(String args[]){
        System.out.println(maxSubArray());
    }

    private static int maxSubArray(){
        int [] input = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int maximumSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;
        for(int i = 0; i < input.length; i++){
            int runningWindowSum = 0;
            for(int k = i; k < input.length; k++){
                runningWindowSum = runningWindowSum + input[k];
                if(runningWindowSum > maximumSum){
                    maximumSum = runningWindowSum;
                    startIndex = i;
                    endIndex = k;
                }
            }
        }
        System.out.println("Found Maximum Subarray between {} and {} " +  startIndex +  endIndex);
        return maximumSum;
    }
}
