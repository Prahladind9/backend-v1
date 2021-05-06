package edu.prahlad.udemy.search;

public class NaiveStringSearch {

    private static final int naiveStringSearch(String longS, String shortS) {
        if (shortS.length() > longS.length())
            return 0;
        char[] longString = longS.toCharArray();
        char[] shortString = shortS.toCharArray();
        int counter = 0;
        for (int i = 0; i < longString.length; i++) {
            boolean check = false;
            for (int j = 0; j < shortString.length; j++) {
                if (longString[i + j] == shortString[j]) {
                    check = true;
                } else {
                    check = false;
                    break;
                }
            }
            if (check)
                counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println("patternMatched "+ naiveStringSearch("wowomgzomgomghjyomhokgomg", "omg"));
        System.out.println("patternMatched "+ naiveStringSearch("lorie loled", "lol"));
        System.out.println("patternMatched "+ naiveStringSearch("lo", "lol"));
    }
}
