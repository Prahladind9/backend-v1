package edu.prahlad.CodeWithMosh.part2.treesAVL;

public class AVLRunner {
    public static void main(String[] args) {
        var tree= new AVLTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        System.out.println(tree);
    }
}
