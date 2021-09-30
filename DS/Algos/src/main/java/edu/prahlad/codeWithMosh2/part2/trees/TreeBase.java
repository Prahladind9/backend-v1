package edu.prahlad.codeWithMosh2.part2.trees;

@FunctionalInterface
public interface TreeBase {
    void customizeInitializeTree(Tree tree);
    default void getInitializedTree(final Tree tree){
        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
    }
}
