package edu.prahlad.zinterview.zolando;

public class Tes2 {

    public static String solution(String S) {

        if (S == null) return null;
        int i = 0;
        while (i < S.length() - 1 && S.length() > 1) {

            if (S.charAt(i) == 'A' &&
                    S.charAt(i + 1) == 'B') {
                S = S.replaceAll("AB", "");
                i = 0;
            } else if (S.charAt(i) == 'B' &&
                    S.charAt(i + 1) == 'A') {
                S = S.replaceAll("BA", "");
                i = 0;
            } else if (S.charAt(i) == 'C' &&
                    S.charAt(i + 1) == 'D') {
                S = S.replaceAll("CD", "");
                i = 0;
            } else if (S.charAt(i) == 'D' &&
                    S.charAt(i + 1) == 'C') {
                S = S.replaceAll("DC", "");
                i = 0;
            } else {
                i++;
            }

        }

        return S;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBACD"));
        System.out.println(solution("CABABD"));
    }
}
