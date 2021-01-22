package leetcode.learn.DataStructures.Array101;

/**
 * https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
 */
public class FindNumbersWithEvenNoOfDigits {
    public static void main(String[] args) {
        FindNumbersWithEvenNoOfDigits findNumbersWithEvenNoOfDigits = new FindNumbersWithEvenNoOfDigits();
        System.out.println(findNumbersWithEvenNoOfDigits.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbersWithEvenNoOfDigits.findNumbers(new int[]{555,901,482,1771}));
    }

    public int findNumbers(int[] nums) {
        //We'll check the length of the array value - even then increment the count ..

        int noOfEven = 0;
        for (int num : nums) {
            if (isEven(num))
                ++noOfEven;
        }

        return noOfEven;
    }

    private boolean isEven(int num) {
        return noOfDigits(num) % 2 == 0;
    }

    private int noOfDigits2(int number) {
        return number + "".length();
    }
    private int noOfDigits(int number) {
        //10^5 is the max number of digits
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }
}
