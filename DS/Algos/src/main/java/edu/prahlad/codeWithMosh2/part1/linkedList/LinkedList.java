package edu.prahlad.codeWithMosh2.part1.linkedList;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }


        private Node first;
        private Node last;
        private int size;
    }
}