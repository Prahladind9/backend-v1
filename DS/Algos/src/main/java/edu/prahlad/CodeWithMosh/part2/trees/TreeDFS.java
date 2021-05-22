package edu.prahlad.CodeWithMosh.part2.trees;

/*
Can be implemented in Tree class itself, just for better clarity
 */
public class TreeDFS extends Tree{

    public void transversePreOrder(){
        transversePreOrder(this.root);
    }

    private void transversePreOrder(final Node root){
        if(root == null) return; //baseCondition
        System.out.print(root.value + ", ");
        transversePreOrder(root.leftChild);
        transversePreOrder(root.rightChild);
    }

    public void transverseInOrderAsc(){
        transverseInOrderAsc(this.root);
    }

    private void transverseInOrderAsc(final Node root){
        if(root == null) return; //baseCondition
        transverseInOrderAsc(root.leftChild);
        System.out.print(root.value+ ", ");
        transverseInOrderAsc(root.rightChild);
    }

    public void transverseInOrderDsc(){
        transverseInOrderDsc(this.root);
    }

    private void transverseInOrderDsc(final Node root){
        if(root == null) return; //baseCondition
        transverseInOrderDsc(root.rightChild);
        System.out.print(root.value+ ", ");
        transverseInOrderDsc(root.leftChild);
    }

    public void transversePostOrder(){
        transversePostOrder(this.root);
    }

    private void transversePostOrder(final Node root){
        if(root == null) return; //baseCondition
        transversePostOrder(root.leftChild);
        transversePostOrder(root.rightChild);
        System.out.print(root.value+ ", ");
    }


    public static void main(String[] args) {
        TreeDFS tree = new TreeDFS();
        tree.getInitializedTree(tree);
        System.out.println(tree);
        tree.transversePreOrder();
        System.out.println();
        tree.transverseInOrderAsc();
        System.out.println();
        tree.transverseInOrderDsc();
        System.out.println();
        tree.transversePostOrder();
    }
}
