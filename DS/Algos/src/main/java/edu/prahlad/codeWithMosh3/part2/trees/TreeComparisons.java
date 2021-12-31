package edu.prahlad.codeWithMosh3.part2.trees;

import java.util.ArrayList;

public class TreeComparisons extends Tree {

    //BinaryTree Equality
    public boolean equals(final Tree other){
        if(other == null) return false; //baseCondition
        return equals(this.root, other.root);
    }

    //preOrderTraversal
    private boolean equals(Node first, Node second) {
        if(first == null && second == null) return true; //baseCondition

        if(first != null && second != null)
            return first.value == second.value &&
                    equals(first.leftChild, second.leftChild) &&
                    equals(first.rightChild, second.rightChild);

        return false;
    }


    public static void main(String[] args) {
        TreeComparisons tree = new TreeComparisons();
        tree.getInitializedTree(tree);
        TreeComparisons other = new TreeComparisons();
        //other.customInitializeTree(other);
        other.getInitializedTree(other);
        System.out.println(tree.equals(other));

    }
}
