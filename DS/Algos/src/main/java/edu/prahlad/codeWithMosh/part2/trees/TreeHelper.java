package edu.prahlad.codeWithMosh.part2.trees;

@FunctionalInterface
public interface TreeHelper {

    void customInitializeTree(final Tree tree);
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
