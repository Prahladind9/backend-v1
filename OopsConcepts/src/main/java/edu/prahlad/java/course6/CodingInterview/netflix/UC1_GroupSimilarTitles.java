package edu.prahlad.java.course6.CodingInterview.netflix;

import java.util.*;

public class UC1_GroupSimilarTitles {

    public static List<List<String>> groupTitles(String[] strs){
        if(strs.length ==0)
            return new ArrayList<>();

        final Map<String, List<String>> res = new HashMap<>();
        final int[] count = new int[26];
        for(String s: strs){
            Arrays.fill(count, 0);
            for(char c: s.toCharArray()){
                final int index = c -'a';
                count[index] = count[index] +1 ;//count[index]++;
            }

            System.out.println("count> "+ Arrays.stream(count).toArray());
            final StringBuilder delimStr = new StringBuilder("");
            for(int i =0; i < 26; i++){
                delimStr.append('#');
                delimStr.append(count[i]);
            }

            final String key = delimStr.toString();
            System.out.println("key> "+ key);
            if(!res.containsKey((key)))
                res.put(key, new ArrayList<>());

            res.get(key).add(s);
        }

        return new ArrayList<>(res.values());
    }


    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel","dule","speed","spede","deul","cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "spede";

        // Searching for all titles
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
    }
}
