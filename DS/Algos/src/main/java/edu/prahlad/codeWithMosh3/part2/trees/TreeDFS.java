package edu.prahlad.codeWithMosh3.part2.trees;

public class TreeDFS extends Tree{

    public void transversePreOrder(){
        transversePreOrder(root);
    }

    private void transversePreOrder(Node root) {
        if(root == null) return; //baseCondition
        System.out.print(root.value + ", ");
        transversePreOrder(root.leftChild);
        transversePreOrder(root.rightChild);
    }

    public void transverseInOrderAsc(){
        transverseInOrderAsc(root);
    }

    private void transverseInOrderAsc(Node root) {
        if(root == null) return;
        transverseInOrderAsc(root.leftChild);
        System.out.print(root.value + ", ");
        transverseInOrderAsc(root.rightChild);
    }

    public void transverseInOrderDsc(){
        transverseInOrderDsc(root);
    }

    private void transverseInOrderDsc(Node root) {
        if(root == null) return;
        transverseInOrderDsc(root.rightChild);
        System.out.print(root.value+ ", ");
        transverseInOrderDsc(root.leftChild);
    }

    public void transversePostOrder(){
        transversePostOrder(root);
    }

    private void transversePostOrder(Node root) {
        if (root == null) return;
        transversePostOrder(root.leftChild);
        transversePostOrder(root.rightChild);
        System.out.print(root.value+", ");
    }

    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.getInitializedTree(tree);
        System.out.println("transversePreOrder");
        tree.transversePreOrder();
        System.out.println("\ntransverseInOrderAsc");
        tree.transverseInOrderAsc();
        System.out.println("\ntransverseInOrderDsc");
        tree.transverseInOrderDsc();
        System.out.println("\ntransversePostOrder");
        tree.transversePostOrder();
    }
}
