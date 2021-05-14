package edu.prahlad.udemy2.hashtable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Insert - Deletion - Access > O(1)
Separate Chaining Strategy
 */
public class HashTable {
    List<List<KeyMap>> keyMap;
    int length;

    HashTable() {
        this.keyMap = new ArrayList<>(53);
        this.length = 53;
        for (int i = 0; i < this.length; i++) {
            keyMap.add(new ArrayList<>());
        }
    }

    HashTable(int size) {
        this.keyMap = new ArrayList<>(size);
        this.length = size;
        for (int i = 0; i < this.length; i++) {
            keyMap.add(new ArrayList<>());
        }
    }

    public int hash(String key) {
        int total = 0;
        int WEIRD_PRIME = 31;
        for (int i = 0; i < Math.min(key.length(), 100); i++) {
            char ch = key.charAt(i);
            int value = (int) ch - 96;
            total = (total * WEIRD_PRIME + value) % this.length;
        }
        return total;
    }

    public int set(String key, String value) {
        int index = this.hash(key);
        if (this.keyMap.get(index) == null) {
            this.keyMap.set(index, new ArrayList<>());
        }
        this.keyMap.get(index).add(new KeyMap(key, value));
        return index;
    }

    public String get(String key) {
        int index = this.hash(key);
        for (KeyMap keyMap : this.keyMap.get(index)) {
            if (keyMap.key.equals(key))
                return keyMap.value;
        }
        return null;
    }

    public List<String> keys() {
        return this.keyMap.stream()
                .flatMap(t -> t.stream())
                .map(KeyMap::getKey)
                .collect(Collectors.toList());
    }

    public List<String> values() {
        return this.keyMap.stream()
                .flatMap(t -> t.stream())
                .map(KeyMap::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "keyMap=" + keyMap +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        HashTable hashTable = new HashTable(17);
        System.out.println(hashTable.set("hellp", "good"));
        System.out.println(hashTable.set("cats", "fine"));
        System.out.println(hashTable);
        System.out.println(hashTable.get("cats"));
        System.out.println(hashTable.get("frech"));

        System.out.println(hashTable.keys());
        System.out.println(hashTable.values());
    }

}
