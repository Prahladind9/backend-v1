package edu.prahlad.CodeWithMosh.part2.trees;

import java.util.ArrayList;

public class Tree implements TreeHelper {

    //PackagePrivate, classPrivate is the best one
    class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
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

    Node root;

    public void insert(int value) {
        final var newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return;
        }

        var current = this.root;
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

    public boolean find(int value) {
        if (this.root == null)
            throw new IllegalStateException();

        var current = this.root;
        while (current != null) {
            if (value == current.value) {
                return true;
            } else if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            }
        }

        return false;
    }

    public int height() {
        return height(root);
    }

    //PostOrder Traversal Example
    private int height(final Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild)
        );
    }

    private boolean isLeaf(Node root) {
        return root != null && root.leftChild == null && root.rightChild == null;
    }

    public int min() {
        if (root == null) throw new IllegalStateException();
        //return min(root); //ForBinaryTree
        return minBST(root); //ForSearchBinaryTree
    }

    //O(log n)
    //ForBinarySearchTree - balanced Tree, where left node value
    public int minBST(final Node root) {
        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    //ForBinaryTree - child node of sub-array can be greater than root
    private int min(final Node root) {
        if (root == null) return Integer.MAX_VALUE;
        if (isLeaf(root))
            return root.value;

        var leftMin = min(root.leftChild);
        var rightMin = min(root.rightChild);

        return Math.min(Math.min(leftMin, rightMin), root.value);
    }

    //BinaryTree Equality
    public boolean equals(final Tree other) {
        if (other == null) return false;  //baseCondition
        return equals(this.root, other.root);
    }

    //PreOrder Transversal
    private boolean equals(Node first, Node second) {
        if (first == null && second == null) return true; //baseCondition

        if (first != null && second != null)
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //PreOrder Transversal
    private boolean isBinarySearchTree(final Node root, int min, int max) {
        if (root == null) return true;
        if (root.value < min || root.value > max) return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1) &&
                isBinarySearchTree(root.rightChild, root.value + 1, max);

    }

    //Temp method to shuffle the tree
    private void swapRoot() {
        var tmp = root.rightChild;
        root.rightChild = root.leftChild;
        root.leftChild = tmp;
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    //BreadthFirstSearch
    private void getNodesAtDistance(final Node root, int distance, final ArrayList<Integer> list) {
        if (root == null) return;//baseCondition
        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }

    @Override
    public void customInitializeTree(final Tree tree) {
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
        //tree.customInitializeTree(tree);
        tree.getInitializedTree(tree);
        //tree.swapRoot();
        System.out.println(tree);
        System.out.println("isBinarySearchTree: " + tree.isBinarySearchTree());
        System.out.println(tree.find(10));
        System.out.println(tree.find(40));
        System.out.println(tree.find(25));

        System.out.println(tree.height());
        System.out.println(tree.min());

        Tree tree2 = new Tree();
        tree2.customInitializeTree(tree2);
        System.out.println(tree.equals(tree2));

        System.out.println(tree.getNodesAtDistance(2));
    }
}
