package leetcode.learn.DataStructures.Recursion;

public class CheckPalindrome2 {

    public static void main(String[] args) {
        System.out.println(isPalindrome("adal"));
    }

    public static boolean isPalindrome(String text){
        return isPalindrome(text, 0, text.length() -1);
    }

    public static boolean isPalindrome(String text, int start, int end){
        if(text == null){
            return false;
        }

        //Separate case for shortest strings.
        if(start >= end){
            return true;
        }else{
            //Get first and last characters , converted to lowercase.
            char first = Character.toLowerCase(text.charAt(0));
            char last = Character.toLowerCase(text.charAt(end));

            if(Character.isLetter(first) && Character.isLetter(last)){
                //Both are letters
                if(first == last){
                    //Remove both first and last character
                    return isPalindrome(text, start + 1, end -1);
                }else {
                    return false;
                }
            }else if(!Character.isLetter(last)){
                //Remove last Character
                String shorter = text.substring(start, end-1);
                return isPalindrome(shorter);
            }else{
                //Remove first character
                String shorter = text.substring(start+1, end);
                return isPalindrome(shorter);
            }
        }

    }
}
