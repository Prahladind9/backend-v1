package edu.prahlad.java.course3.recursion.ex3;

public class Node {
    String value;
    Node next;

    public Node () {
        value = null;
        next = null;
    }

    public Node (String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String toString () {
        return value + "";
    }
}
