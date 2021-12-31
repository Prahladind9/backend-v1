package edu.prahlad.codeWithMosh3.part2.trees;

import java.util.ArrayList;

public class TreeOperations extends Tree{

    public int height(){
        return height(root);
    }

    //PostOrder Traversal Example
    private int height(Node root) {
        if (root == null) return -1;

        if(isLeaf()) return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild)
        );
    }

    public int min(){
        if(root == null) throw new IllegalStateException();
        return min(root);
    }

    private int min(Node root) {
        if(root == null) return Integer.MAX_VALUE;
        if(isLeaf()) return root.value;

        var leftMin = min(root.leftChild);
        var rightMin = min(root.rightChild);

        return Math.min(Math.min(leftMin, rightMin), root.value);
    }

    public int minForBST(){
        if(root == null) throw new IllegalStateException();
        return minForBST(root);
    }

    private int minForBST(Node root) {
        var current = root;
        var last = current;
        while (current != null){
            last = current;
            current = current.leftChild;
        }

        return last.value;

    }

    private boolean isLeaf(){
        return root != null && root.leftChild == null && root.rightChild == null;
    }


    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    //BreadthFirstSearch
    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list) {
        if(root == null) return; //baseCondition
        if(distance == 0){
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance-1, list);
        getNodesAtDistance(root.rightChild, distance-1, list);
    }

    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.getInitializedTree(tree);
        System.out.println(tree.height());
        System.out.println(tree.min());
        System.out.println(tree.minForBST());
        System.out.println(tree.getNodesAtDistance(11));
    }
}
