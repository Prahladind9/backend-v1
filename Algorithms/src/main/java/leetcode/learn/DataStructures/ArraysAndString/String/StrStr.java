package leetcode.learn.DataStructures.ArraysAndString.String;

public class StrStr {
    public static void main(String[] args) {
        StrStr strStr = new StrStr();
        strStr.strStr("hello", "ll");
        strStr.strStr("hello", "bba");
        strStr.strStr("hello", null);
    }

    public int strStr(String haystack, String needle) {

        if(needle == null){
            System.out.println("0");
            return 0;
        }

        System.out.println(haystack.indexOf(needle));
        return haystack.indexOf(needle);
    }
}
