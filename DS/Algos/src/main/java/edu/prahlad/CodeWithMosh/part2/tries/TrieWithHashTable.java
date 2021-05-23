package edu.prahlad.CodeWithMosh.part2.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TrieWithHashTable extends Trie {

    private class Node {
        private char value;
        private HashMap<Character, Node> children = new HashMap<>(); //
        private boolean isEndOfWord;

        public Node(char value) {
            this.value = value;
        }

        //Abstracting out the functionality
        public boolean hasChild(char ch) {
            return children.containsKey(ch);
        }

        public void addChild(char ch) {
            children.put(ch, new Node(ch));
        }

        public Node getChild(char ch) {
            return children.get(ch);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public void removeChild(char ch) {
            children.remove(ch);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", children=" + children +
                    ", isEndOfWord=" + isEndOfWord +
                    '}';
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {
        var current = root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                current.addChild(ch);

            current = current.getChild(ch);
        }
        current.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (word == null) return false; //or we can throw IllegalArgumentException

        var current = this.root;
        for (var ch : word.toCharArray()) {
            if (!current.hasChild(ch))
                return false;

            current = current.getChild(ch);
        }
        return current.isEndOfWord;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        //traversePreOrder - visit the root first, then children
        //printed in the inserted order
        System.out.println(root.value);

        for (var child : root.getChildren())
            traversePreOrder(child);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        //traversePostOrder - visit children fist & then the root
        //printed in reverse order > mostly to remove the character
        for (var child : root.getChildren())
            traversePostOrder(child);

        System.out.println(root.value);
    }

    public void remove(String word) {
        if (word == null) return;
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        //PostOrderTransversal
        if (index == word.length()) {//baseCondition
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if (child == null) return;

        remove(child, word, index + 1);

        if (!child.hasChildren() && !child.isEndOfWord)
            root.removeChild(ch);

    }

    public List<String> findWords(String word) {
        var lastNode = findLastNodeOf(word);
        List<String> words = new ArrayList<>();
        findWords(lastNode, word, words);

        return words;
    }

    private void findWords(Node root, String prefix, List<String> words) {
        if(root == null) return;

        if (root.isEndOfWord)
            words.add(prefix);

        for (var child : root.getChildren()) {
            findWords(child, prefix + child.value, words);
        }
    }

    private Node findLastNodeOf(String prefix) {
        if (prefix == null) return null;

        var current = root;
        for (var ch : prefix.toCharArray()) {
            var child = current.getChild(ch);
            if (child == null)
                return null;

            current = child;
        }

        return current;
    }


}
