package edu.prahlad.codeWithMosh2.part2.trees;

public class Tree implements TreeBase{

    //PackagePrivate, classPrivate is the best one
     class Node {
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node leftChild, Node rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }

    public Node root;


    public void insert(final int value) {
        final var newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        //Better handling > but this case > isn't always required
        if (find(value))
            throw new IllegalArgumentException("Value already exists in the Tree");

        var current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    public boolean find(final int value) {
        if(root == null){
            throw new IllegalStateException();
        }

        var current = root;
        while (current != null) {
            if (current.value == value) {
                return true;
            } else if (current.value < value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    @Override
    public void customizeInitializeTree(Tree tree) {
        tree.insert(15);
        tree.insert(10);
        tree.insert(20);
        tree.insert(12);
        tree.insert(18);
        tree.insert(25);
        return;
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.getInitializedTree(tree);
        System.out.println(tree);
        System.out.println(tree.find(10));
        System.out.println(tree.find(40));
        System.out.println(tree.find(25));

    }
}
