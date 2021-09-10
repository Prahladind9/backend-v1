package edu.prahlad.codeWithMosh2.part1.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

    public static char findFirstNonRepeatedCharacter(final String str){
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: str.toCharArray()){
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch, count + 1);
        }

        for (Character ch: str.toCharArray()){
            if(map.get(ch) == 1)
                return ch;
        }

        return Character.MIN_VALUE;
    }

    public static char findFirstRepeatedCharacter(final String str){
          final Set<Character> set = new HashSet<>();
          for (var ch: str.toCharArray()){
              if(set.contains(ch))
                  return ch;

              set.add(ch);
          }

          return Character.MIN_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatedCharacter("green apple"));
        System.out.println(findFirstRepeatedCharacter("green apple"));
    }

}
