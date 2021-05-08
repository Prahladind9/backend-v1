package edu.prahlad.udemy2.doublyLinkedList;

class Node {
    public String val;
    public Node next;
    public Node prev;

    public Node(String val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
}
