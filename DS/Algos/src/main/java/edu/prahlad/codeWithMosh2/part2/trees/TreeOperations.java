package edu.prahlad.codeWithMosh2.part2.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreeOperations extends TreeActions {


    public boolean equals(Tree other) {
        if (other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true;

        if (first != null && second != null) {
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public void swapRoot() {
        var temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;

        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public List printNodesAtDistance(int distance) {
        List list = new ArrayList<>();
        if (distance < 0) return Collections.EMPTY_LIST;
        printNodesAtDistance(root, distance, list);
        return list;
    }

    private void printNodesAtDistance(Node root, int distance, List<Integer> list) {
        if (root == null) return;

        if (distance == 0) {
            list.add(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1, list);
        printNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.getInitializedTree(tree);

        TreeOperations other = new TreeOperations();
        other.getInitializedTree(other);

        System.out.println(tree.equals(other));
        System.out.println(tree.equals(null));
        System.out.println(tree.isBinarySearchTree());
        tree.swapRoot();
        System.out.println(tree.isBinarySearchTree());

        System.out.println(tree.printNodesAtDistance(2));
    }
}
