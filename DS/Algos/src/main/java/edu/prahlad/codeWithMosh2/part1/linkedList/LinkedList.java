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
    }


    private Node first;
    private Node last;
    private int size;

    public int size(){
        return size;
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    public static void main(String[] args) {
        var linkedList = new LinkedList();
        System.out.println(linkedList.size());
    }
}