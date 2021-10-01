package edu.prahlad.codeWithMosh2.part2.trees;

public class TreeActions extends Tree {

    private boolean isLeaf(Node root) {
        return isRootNull(root.leftChild) && isRootNull(root.rightChild);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (isRootNull(root)) return -1;
        if (isLeaf(root)) return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int minForBinarySearchTree() {
        if(isRootNull(root)) throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    private boolean isRootNull(Node root) {
        return root == null;
    }

    public int minForBinaryTree() {
        return minForBinaryTree(root);
    }

    private int minForBinaryTree(Node root) {
        if (isRootNull(root)) throw new IllegalStateException();
        if (isLeaf(root)) return root.value;

        var left = minForBinaryTree(root.leftChild);
        var right = minForBinaryTree(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }


    public static void main(String[] args) {
        TreeActions tree = new TreeActions();
        tree.getInitializedTree(tree);

        System.out.println(tree.height());
        System.out.println(tree.minForBinaryTree());
        System.out.println(tree.minForBinarySearchTree());
    }
}
