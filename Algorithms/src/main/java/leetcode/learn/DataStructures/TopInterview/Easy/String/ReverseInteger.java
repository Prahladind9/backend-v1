package leetcode.learn.DataStructures.TopInterview.Easy.String;

public class ReverseInteger {
    public static void main(String[] args) {
//        char[] chars = "hello".toCharArray();
        ReverseInteger reverseString = new ReverseInteger();
        reverseString.reverseInteger(-123);
        reverseString.reverseInteger(1534236469);
    }

    public int reverseInteger(int reverseInteger) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        System.out.println(reverseInteger);


        boolean isNeg = false;
        if(reverseInteger == 0){
            return reverseInteger;
        }

        if(reverseInteger < 0){
            isNeg = true;
            reverseInteger = reverseInteger * -1;
        }

        char[] reverseIntegerArr = String.valueOf(reverseInteger).toCharArray();
        char temp;
        for(int i=0; i < reverseIntegerArr.length/2; i++){
            temp = reverseIntegerArr[i];
            reverseIntegerArr[i] = reverseIntegerArr[reverseIntegerArr.length-i-1];
            reverseIntegerArr[reverseIntegerArr.length-i-1] = temp;
        }
        System.out.println(reverseIntegerArr);
        System.out.println(reverseIntegerArr.toString());

        //Edge Case Integer Overflow
        try {
            reverseInteger = Integer.valueOf(String.valueOf(reverseIntegerArr));
        }catch (NumberFormatException e){
            return 0;
        }
        if(isNeg){
            reverseInteger = reverseInteger * -1;
        }
        System.out.println(reverseInteger);
        return reverseInteger;
    }
}
