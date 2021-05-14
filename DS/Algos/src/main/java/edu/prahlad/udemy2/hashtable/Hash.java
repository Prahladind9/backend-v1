package edu.prahlad.udemy2.hashtable;

class KeyMap {
    String key;
    String value;

    public KeyMap(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "KeyMap{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}

public class Hash {


    public int hashV2 (String key, int arrayLen){
        int total = 0;
        int WEIRD_PRIME = 31;
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total * WEIRD_PRIME + value) % arrayLen;
        }
        return total;
    }

    /**
     * Problem with hash V1
     * 1. Only hashes strings
     * 2. Not constant time - linear in key length
     * 3. Could be a little more random
     */
    public int hashV1 (String key, int arrayLen){
        int total = 0;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total+ value) % arrayLen;
        }
        return total;
    }

    public int hashV0 (String key, int arrayLen){
        int total = 0;
        for (char ch: key.toCharArray()){
            int value = (int) ch - 96;
            total = (total+ value) % arrayLen;
        }
        return total;
    }
}
