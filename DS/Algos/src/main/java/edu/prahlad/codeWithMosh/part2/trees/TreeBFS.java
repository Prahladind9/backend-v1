package edu.prahlad.codeWithMosh.part2.trees;

public class TreeBFS extends Tree{
    public void traverseLevelOrder(){
        for (int i = 0; i <= height(); i++) {
            for (var value: getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.getInitializedTree(tree);
        System.out.println(tree);
        tree.traverseLevelOrder();
    }
}
