package leetcode.Monthly.April.One;

public class BestTimeBuySellStockII {

    public static void main(String[] args) {
        maxProfit(new int[]{7,1,5,3,6,4});
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1; i < prices.length; i++){
            int diff = prices[i] - prices[i-1];
            if(diff >0){
                profit = profit + diff;
            }
        }

        return profit;
    }

}
