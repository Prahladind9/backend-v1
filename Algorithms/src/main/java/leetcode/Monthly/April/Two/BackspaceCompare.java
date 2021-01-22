package leetcode.Monthly.April.Two;

public class BackspaceCompare {

    public static void main(String[] args) {
//        System.out.println(backspaceCompare("ab#c","ad#c"));
        System.out.println(backspaceCompare("#a#c", "a##c"));

        System.out.println(backspaceCompare("oi###mupo##rszty#s#xu###bxx##dqc#gdjz",
                "oi###mu#ueo##pk#o##rsztu#y#s#xu###bxx##dqc#gz#djz"));
    }

    public static boolean backspaceCompare(String S, String T) {
        String k = formattedWord(S);
        String l = formattedWord(T);
        if( k.equals(l))
            return true;
        return false;
    }

    private static String formattedWord(String ST){
        while(ST.contains("#")) {
            int k = ST.indexOf("#");
            if(k != -1)
                ST = ST.replaceFirst(ST.substring(k, k+1), "");
            if(k-1 != -1)
                ST = ST.replaceFirst(ST.substring(k-1, k), "");
        }
        return ST;
    }
}
