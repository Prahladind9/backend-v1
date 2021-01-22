package leetcode.learn.DataStructures.ArraysAndString.String;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        System.out.println("hello".indexOf(9));

        LongestCommonPrefix  longestCommonPrefix= new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(null));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[]{""}));
    }



    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }

        if(strs[0].isEmpty())
            return "";

        String prefix="";
        for(int i= 0; true; i++){
            prefix = strs[0].substring(0,i);
            for(int j=1; j<strs.length; j++){

                if(strs[j].isEmpty())
                    return "";

                if(strs[j].length()>i & prefix.equals(strs[j].substring(0,i))){
                    System.out.println("ith Index " + i + " matching for j " + j + " val " + strs[j].substring(0,i));
                }else {
                    if(i ==0) {
                        return "";
                    }else{
                        System.out.println("i " + i);
                        System.out.println("prefix " + prefix);
                        System.out.println("prefix val " + strs[0].substring(0,i-1));
                        return  strs[0].substring(0,i-1);
                    }
                }

            }

        }

    }
}
