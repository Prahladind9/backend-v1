package edu.prahlad.codeWithMosh3.part2.trees;

public class Tree implements TreeHelper{

    Node root;

    public void insert(int value){
        final var newNode = new Node(value);
        if(this.root == null){
            this.root = newNode;
            return;
        }

        var current = this.root;
        while (true){
            if(value < current.value){
                if(current.leftChild == null){
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            }else {
                if(current.rightChild == null){
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }


    public boolean find(int value){
        if(this.root == null) throw new IllegalStateException();

        var current = this.root;
        while (current != null){
            if(value == current.value){
                return true;
            }else if(value < current.value){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }
        }

        return false;
    }


    @Override
    public void customInitializeTree(Tree tree) {
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
        //tree.swapRoot();
        System.out.println(tree);
        //System.out.println("isBinarySearchTree: " + tree.isBinarySearchTree());
        System.out.println(tree.find(10));
        System.out.println(tree.find(40));
        System.out.println(tree.find(25));
    }
}
