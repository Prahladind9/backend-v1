package edu.prahlad.codeWithMosh3.part2.trees;

public class TreeValidations extends Tree{

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //PreOrder Traversal
    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) return true;
        if(root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);

    }

    public static void main(String[] args) {
        TreeValidations tree = new TreeValidations();
        tree.getInitializedTree(tree);
//        tree.customInitializeTree(tree);
        System.out.println("isBinarySearchTree: " + tree.isBinarySearchTree());
    }
}
