package edu.prahlad.CodeWithMosh.part3.stringManipulation;

public class ZStringRunner {
    public static void main(String[] args) {
        System.out.println(StringUtils.countVowels("Hello World"));
        System.out.println(StringUtils.reverseV0("Hello World"));
        System.out.println(StringUtils.reverse("Hello World"));
        System.out.println(StringUtils.reverseWordsV0("This is Mango Season"));
        System.out.println(StringUtils.reverseWords("This is Mango Season"));
        System.out.println(StringUtils.areRotationsV0("ABCD", "DABC"));
        System.out.println(StringUtils.areRotations("ABCD", "DABC"));
        System.out.println(StringUtils.removeDuplicates("Trees are beautiful"));

        System.out.println(StringUtils.getMaxRecurringCharV0("Trees are beautiful"));
        System.out.println(StringUtils.getMaxRecurringChar("Trees are beautiful!!!!!!!!!!"));

        System.out.println(StringUtils.capitalizeEveryWordOfSentence("today is a great day"));

        System.out.println(StringUtils.areAnagramsV0("ABCD", "DBCA"));
        System.out.println(StringUtils.areAnagrams("ABCD", "DBCA"));

        System.out.println(StringUtils.isPalindromeV0("ABCD"));
        System.out.println(StringUtils.isPalindrome("ABBA"));
    }
}