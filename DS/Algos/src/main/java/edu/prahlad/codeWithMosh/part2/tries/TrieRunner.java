package edu.prahlad.codeWithMosh.part2.tries;

public class TrieRunner {
    public static void main(String[] args) {

        //All small case as of now
        var trieWithArray = new TrieWithArray();
        trieWithArray.insert("cat");
        trieWithArray.insert("can");
        trieWithArray.insert("word");
        System.out.println(trieWithArray);

        var trie = new TrieWithHashTable();
        trie.insert("car");
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        trie.insert("mango");
        trie.insert("canada");
        System.out.println(trie.contains("can"));
        System.out.println(trie.contains(null));
        System.out.println(trie.contains("canada"));

        //printed in actual inserted order
        trie.traversePreOrder();
        System.out.println();
        //printed in reverse order
        trie.traversePostOrder();

        trie.remove("car");
        trie.remove("book"); //edgeCase
        trie.remove(null); //edgeCase

        System.out.println(trie.findWords("care"));
        System.out.println(trie.findWords("cargo"));//edgeCase
        System.out.println(trie.findWords("c"));//edgeCase
        System.out.println(trie.findWords(""));//edgeCase
        System.out.println(trie.findWords(null));//edgeCase
    }
}
