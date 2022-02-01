package edu.prahlad.zinterview.twillio;

import java.util.*;

public class VanityNumberSearch {
    public static List<String> vanity(List<String> codes, List<String> numbers) {
        List<String> result = new ArrayList<>();
        Set<String> numSeqs = new HashSet<>();

        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        for(String code: codes){
            StringBuilder numSeq = new StringBuilder();

            for(Character c: code.toCharArray()){
                Character ch = Character.toLowerCase(c);

                for(Map.Entry<Integer, String> entry: map.entrySet()){
                    if(entry.getValue().contains(ch.toString())){
                        numSeq.append(entry.getKey());
                        break;
                    }
                }
            }
            numSeqs.add(numSeq.toString());
        }


        for(String number: numbers){
            for(String code:  numSeqs){
                if(number.contains(code)){
                    if(!result.contains(number))
                        result.add(number);
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}
