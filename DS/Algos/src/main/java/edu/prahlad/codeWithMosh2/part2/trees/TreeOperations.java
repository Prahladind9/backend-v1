package edu.prahlad.codeWithMosh2.part2.trees;

public class TreeOperations extends TreeActions{


    public boolean equals(Tree other){
        if(other == null) return false;
        return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
        if(first == null && second == null) return true;

        if(first !=null && second != null){
            return first.value == second.value
                    && equals(first.leftChild, second.leftChild)
                    && equals(first.rightChild, second.rightChild);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeOperations tree = new TreeOperations();
        tree.getInitializedTree(tree);

        TreeOperations other = new TreeOperations();
        other.getInitializedTree(other);

        System.out.println(tree.equals(other));
        System.out.println(tree.equals(null));
    }
}
