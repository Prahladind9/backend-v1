package edu.prahlad.educativeio.recursion.string;

public class AlphabeticMerge {

    private static String alphabeticMerge(String one, String two){
        //base case 1
        if(one == null || one.equals("")){
            return two == null? one: two;
        }//base case 2
        else if(two == null|| two.equals("")){
            return one;
        }
        //recursive case
        else if(two.charAt(0) > one.charAt(0)){
            return one.charAt(0) + alphabeticMerge(one.substring(1), two);
        }
        else {
            return two.charAt(0) + alphabeticMerge(one, two.substring(1));
        }

    }

    public static void main( String args[] ) {
        String one = "adz";
        String two = "bfx";
        String answer = alphabeticMerge(one, two);
        System.out.println(answer);
    }

}
