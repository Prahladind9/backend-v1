package edu.prahlad.udemy2.singleLinkedList;

public class NodeRunner {
    public static void main(String[] args) {
        Node first = new Node("Hi");
        first.next = new Node("there");
        first.next.next = new Node("how");
        first.next.next.next = new Node("are");
        first.next.next.next.next = new Node("you");

        System.out.println(first);
    }
}
