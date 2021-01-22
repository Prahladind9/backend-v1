package leetcode.Monthly.April.One;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagramsBF(new String[]{"", ""});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List> sol = new HashMap<String, List>();
        for(String s: strs){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!sol.containsKey(key)){
                sol.put(key, new ArrayList());
            }
            sol.get(key).add(s);
        }

        return new ArrayList(sol.values());
    }

    public static List<List<String>> groupAnagramsBF(String[] strs) {
        if(strs.length == 0){
            return new ArrayList<List<String>>();
        }
        if(strs.length == 1){
            List<List<String>> sol = new ArrayList<List<String>>();
            List<String> temp = new ArrayList<String>();
            temp.add(strs[0]);
            sol.add(temp);
            return sol;
        }
        List<List<String>> sol = new ArrayList<List<String>>();
        List<Integer> skipIndex = new ArrayList<Integer>();
        for (int i = 0; i < strs.length; i++) {
            if (!skipIndex.contains(i)) {
                skipIndex.add(i);
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                if(strs[i].length() !=0) {
                    String sortedIIndex = sortString(strs[i]);
                    String sortedIIndex0 = sortedIIndex.substring(0, 1);
                    for (int k = i; k < strs.length - 1; k++) {
                        if (strs[k + 1].contains(sortedIIndex0) &
                                sortedIIndex.equals(sortString(strs[k + 1]))) {
                            skipIndex.add(k + 1);
                            temp.add(strs[k + 1]);
                        }
                    }
                }else{
                    for (int k = i; k < strs.length - 1; k++) {
                        if (strs[k + 1].equals(strs[i])) {
                            skipIndex.add(k + 1);
                            temp.add(strs[k + 1]);
                        }
                    }
                }
                sol.add(temp);
            }
        }

        return sol;
    }

    private static String sortString(String string) {
        char arr[] = string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
