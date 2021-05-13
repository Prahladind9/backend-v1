package edu.prahlad.udemy2.tree.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Insertion * searching > O(log(n))
 * **Not guaranteed > root dependent, we may have to restructure
 */
public class BinarySearchTreeTransverse {
    Node root;

    public BinarySearchTreeTransverse() {
        this.root = null;
    }

    public BinarySearchTreeTransverse insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return this;
        } else {
            Node current = this.root;
            while (true) {

                if (value == current.value) {
                    return null;
                }

                if (value < current.value) {
                    if (current.left == null) {
                        current.left = newNode;
                        return this;
                    } else {
                        current = current.left;
                    }
                } else if (value > current.value) {
                    if (current.right == null) {
                        current.right = newNode;
                        return this;
                    } else {
                        current = current.right;
                    }
                }
            }
        }

    }

    public List<Integer> BFS() {
        Node node = this.root;
        List<Integer> data = new ArrayList<>();
        List<Node> queue = new ArrayList<>();
        queue.add(this.root);

        while (queue.size() > 0) {
            node = queue.remove(0);
            data.add(node.value);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return data;

    }

    public List<Integer> DFSPreOrder() {
        List<Integer> data = new ArrayList<>();
//        Node current = this.root; //in case use passes, particular Node as input
//        traverse(current, data);

        traverseDFSPreOrder(this.root, data);
        return data;
    }

    private void traverseDFSPreOrder(final Node node, final List<Integer> data) {
        data.add(node.value);
        if (node.left != null) traverseDFSPreOrder(node.left, data);
        if (node.right != null) traverseDFSPreOrder(node.right, data);
    }

    public List<Integer> DFSPostOrder() {
        List<Integer> data = new ArrayList<>();
        traverseDFSPostOrder(this.root, data);
        return data;
    }

    private void traverseDFSPostOrder(final Node node, final List<Integer> data) {
        if (node.left != null) traverseDFSPostOrder(node.left, data);
        if (node.right != null) traverseDFSPostOrder(node.right, data);
        data.add(node.value);
    }

    public List<Integer> DFSInOrder() {
        List<Integer> data = new ArrayList<>();
        traverseDFSInOrder(this.root, data);
        return data;
    }

    private void traverseDFSInOrder(final Node node, final List<Integer> data) {
        if (node.left != null) traverseDFSInOrder(node.left, data);
        data.add(node.value);
        if (node.right != null) traverseDFSInOrder(node.right, data);
    }


    public static void main(String[] args) {
        BinarySearchTreeTransverse tree = new BinarySearchTreeTransverse();
        tree.insert(10);
        tree.insert(6);
        tree.insert(15);
        tree.insert(3);
        tree.insert(8);
        tree.insert(20);

        /*
                    10
                 6      15
              3    8        20
         */

        System.out.println("\n//--------BFS-------------//");
        System.out.println(tree.BFS());

        System.out.println("\n//--------DFS PreOrder-------------//");
        System.out.println(tree.DFSPreOrder());

        System.out.println("\n//--------DFS PostOrder-------------//");
        System.out.println(tree.DFSPostOrder());

        System.out.println("\n//--------DFS InOrder-------------//");
        System.out.println(tree.DFSInOrder());
    }
}
