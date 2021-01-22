package leetcode.Monthly.May;

public class StockSpanner {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] ar1 = new int[]{31, 41, 48, 59, 79};
        int[] ar = new int[]{100, 80, 60, 70, 60, 75, 85};
        for (int val : ar) {
            System.out.println(stockSpanner.next(val));
        }

    }

    int[] stockValues = new int[10000];
    int counter;
    int global;

    public StockSpanner() {
        global = 0;
        counter = 0;
    }

    public int next(int price) {
        if (global == 0) {
            global = price;
            stockValues[counter] = price;
            return 1;
        }

        ++counter;
        stockValues[counter] = price;

        if (price > global) {
            int length = counter;
            for (int i = length; i > 0; i--, length--) {
                if (stockValues[i] > price ) {
                    break;
                }
            }
            if(length == 0) {
                return counter - length+1;
            }else{
                return counter - length;
            }
        } else {
            global = price;
            return 1;
        }
    }


    public int next2(int price) {
        if (global == 0) {
            global = price;
            return counter;
        }

        if (price > global) {
            global = price;
            ++counter;
            return counter;
        } else {
            global = price;
            return 1;
        }
    }

}
