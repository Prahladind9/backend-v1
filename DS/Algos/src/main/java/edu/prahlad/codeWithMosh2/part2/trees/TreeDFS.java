package edu.prahlad.codeWithMosh2.part2.trees;

public class TreeDFS extends Tree{

    private boolean baseCondition(Node root) {
        return root == null;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(baseCondition(root)) return;

        System.out.print(root.value + ", ");
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(baseCondition(root)) return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + ", ");
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if(baseCondition(root)) return;

        traversePostOrder(root.rightChild);
        System.out.print(root.value + ", ");
        traversePostOrder(root.leftChild);
    }

    public static void main(String[] args) {

        TreeDFS tree = new TreeDFS();
        tree.getInitializedTree(tree);

        System.out.println("traversePreOrder");
        tree.traversePreOrder();
        System.out.println("\ntraverseInOrder");
        tree.traverseInOrder();
        System.out.println("\ntraversePostOrder");
        tree.traversePostOrder();

    }
}
