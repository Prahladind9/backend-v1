package edu.prahlad.zeroToMastery.linkedList;

public class LinkedList {

    Node head;
    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}

class Node {
    int data;
    edu.prahlad.zeroToMastery.linkedList.Node next;

    Node(int d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

