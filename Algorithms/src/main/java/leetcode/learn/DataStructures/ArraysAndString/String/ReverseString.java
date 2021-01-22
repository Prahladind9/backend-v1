package leetcode.learn.DataStructures.ArraysAndString.String;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString("hitopp".toCharArray());
    }
    public void helper(char[] s, int left, int right) {
        System.out.println(String.valueOf(s));
        if (left >= right) return;
        char tmp = s[left];
        s[left++] = s[right];
        s[right--] = tmp;
        helper(s, left, right);
    }

    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
        System.out.println(String.valueOf(s));
    }
}