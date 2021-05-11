package edu.prahlad.udemy2.tree.binarySearchTree;

public class Node {
    Node left;
    Node right;
    int value;

    public Node(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "left=" + left +
                ", right=" + right +
                ", value=" + value +
                '}';
    }
}
