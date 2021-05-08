package edu.prahlad.udemy2.singleLinkedList;

class Node {
    public String val;
    public Node next;

    public Node(String val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
}
