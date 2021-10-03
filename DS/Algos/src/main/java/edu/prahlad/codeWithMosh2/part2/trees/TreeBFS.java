package edu.prahlad.codeWithMosh2.part2.trees;

public class TreeBFS extends TreeOperations{

    public void traverseLevelOrder(){
        for (int i = 0; i <= height() ; i++) {
            var list = printNodesAtDistance(i);
            System.out.println(list);
        }
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.getInitializedTree(tree);
        tree.traverseLevelOrder();
    }
}
