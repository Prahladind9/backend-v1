package edu.prahlad.codeWithMosh3.part2.trees;

@FunctionalInterface
public interface TreeHelper {

    class Node{
        int value;
        Tree.Node leftChild;
        Tree.Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }

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
