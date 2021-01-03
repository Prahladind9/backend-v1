package edu.prahlad.java.concurrency;

import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAdder;

public class ConcurrentMapRunner {
    public static void main(String[] args) {
        ConcurrentMap<Character, LongAdder> occurrences = new ConcurrentHashMap<>();
        //Multiple region lock on the map

        String str = "ABCD ABCD ABCD";
        for(char character: str.toCharArray()){
            occurrences.computeIfAbsent(character, ch -> new LongAdder()).increment();
        }

        System.out.println(occurrences);
    }

    private static void notThreadSafe() {
        String str = "ABCD ABCD ABCD";
        Map<Character, LongAdder> occurrences = new Hashtable<>();

        for(char character: str.toCharArray()){
            LongAdder longAdder = occurrences.get(character);
            if(longAdder == null){
                longAdder = new LongAdder();
            }
            longAdder.increment();
            occurrences.put(character, longAdder);
        }

        System.out.println(occurrences);
    }
}
