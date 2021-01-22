package leetcode.Monthly.May;

import java.util.HashMap;

public class CheckInclusion {
    public static void main(String[] args) {

        CheckInclusion checkInclusion = new CheckInclusion();
        checkInclusion.checkInclusion("abc", "bbbbaaaa");
        checkInclusion.checkInclusion("abc", "ccccbbbbaaaa");
        checkInclusion.checkInclusion("ab", "eidbaooo");
        checkInclusion.checkInclusion("ab", "boa");
        checkInclusion.checkInclusion("ab", "eidboaooo");
    }

    public boolean checkInclusion(String s1, String s2) {
        boolean checkInclusion = false;
        HashMap<Character, Integer> map = new HashMap<>();
        int s1Val = 0;

        for (char val : s1.toCharArray()) {
            s1Val = s1Val + val;
            if(map.get(val) != null) {
                map.put(val, 1 + map.get(val));
            }else{
                map.put(val, 1);
            }
        }

        char[] s2Char = s2.toCharArray();
        int s2Val = 0;
        for (int i = 0; i < s2Char.length - s1.length() + 1; i++) {
            s2Val = 0;
            HashMap<Character, Integer> mapTemp = (HashMap<Character, Integer>) map.clone();

            for (int k = i; k < i + s1.length(); k++) {
                s2Val = s2Val + s2Char[k];
                Integer temp = mapTemp.get(s2Char[k]);
                if (temp != null && temp > 0) {
                    checkInclusion = true;
                    mapTemp.put(s2Char[k], temp - 1);
                } else {
                    checkInclusion = false;
                    break;
                }
            }
            if (checkInclusion && s1Val == s2Val) {
                break;
            } else {
                checkInclusion = false;
            }
        }

        return checkInclusion;
    }
}
