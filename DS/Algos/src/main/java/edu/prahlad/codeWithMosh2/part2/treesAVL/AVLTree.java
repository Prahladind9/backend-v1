package edu.prahlad.codeWithMosh2.part2.treesAVL;

public class AVLTree {
    class AVLNode {
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "AVLNode{" +
                    "value=" + value +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    ", height=" + height +
                    '}';
        }
    }


    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) return new AVLNode(value);

        if (value > root.value) {
            root.rightChild = insert(root.rightChild, value);
        } else {
            root.leftChild = insert(root.leftChild, value);
        }

        setHeight(root);
        return balance(root);

    }

    private AVLNode balance(AVLNode root){
        if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild) < 0){
                root.leftChild = rotateLeft(root.leftChild);
            }
           return rotateRight(root);
        }
        else if(isRightHeavy(root)) {
            if(balanceFactor(root.rightChild) > 0){
                root.rightChild = rotateRight(root.rightChild);
            }
            return rotateLeft(root);
        }

        return root;
    }

    private AVLNode rotateLeft(AVLNode root){
        var newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root){
        var newRoot = root.leftChild;
        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(
                height(node.leftChild),
                height(node.rightChild)) + 1;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.height;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return node == null ? 0 :
                height(node.leftChild) - height(node.rightChild);
    }

    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        //10
        //   20
        //      30

        var tree = new AVLTree();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        System.out.println(tree);
    }

}
