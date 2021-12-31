package edu.prahlad.codeWithMosh3.part2.trees;

public class TreeBFS extends TreeOperations {

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (var value : getNodesAtDistance(i))
                System.out.print(value + ", ");
        }
    }

    public static void main(String[] args) {
        TreeBFS tree = new TreeBFS();
        tree.getInitializedTree(tree);
        tree.traverseLevelOrder();
    }
}
