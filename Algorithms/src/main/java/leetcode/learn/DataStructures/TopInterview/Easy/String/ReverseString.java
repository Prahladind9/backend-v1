package leetcode.learn.DataStructures.TopInterview.Easy.String;

public class ReverseString {
    public static void main(String[] args) {
//        char[] chars = "hello".toCharArray();
        char[] chars = "he".toCharArray();
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(chars);
    }

    public void reverseString(char[] reverseString) {

        if(reverseString.length < 1){
            return;
        }

        char temp;
        for(int i=0; i < reverseString.length/2; i++){
            temp = reverseString[i];
            reverseString[i] = reverseString[reverseString.length-i-1];
            reverseString[reverseString.length-i-1] = temp;
        }
        System.out.println(reverseString);
    }
}
