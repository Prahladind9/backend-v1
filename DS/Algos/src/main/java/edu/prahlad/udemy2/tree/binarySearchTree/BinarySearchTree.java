package edu.prahlad.udemy2.tree.binarySearchTree;

/**
 * Insertion * searching > O(log(n))
 *  **Not guaranteed > root dependent, we may have to restructure
 */
public class BinarySearchTree {
    Node root ;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree insert(int value){
        Node newNode = new Node(value);
        if(this.root == null){
            this.root = newNode;
            return this;
        }else{
            Node current = this.root;
            while(true){

                if(value == current.value){
                    return null;
                }

                if(value < current.value){
                    if(current.left == null){
                        current.left = newNode;
                        return this;
                    }else{
                        current = current.left;
                    }
                }else if(value > current.value){
                    if(current.right == null){
                        current.right = newNode;
                        return this;
                    }else{
                        current = current.right;
                    }
                }
            }
        }

    }

    public Node find(int value){
        if(this.root == null) {
            return null;
        }
        Node current = this.root;
        boolean found = false;

        while (current != null && !found){
            if(value < current.value){
                current = current.left;
            }else if(value > current.value){
                current = current.right;
            }else {
                found = true;
            }
        }
        return current;
    }

    public boolean contains(int value){
        return find(value) == null? false: true;
    }

    @Override
    public String toString()
    {
        return toString(root);
    }

    private String toString(Node root)
    {
        String result = "";

        if(root == null)
        {
            result = "empty";
        }
        else
        {
            result = result + root.value;

            if(root.left != null || root.right != null)
            {
                result = "(" + result + ", "
                        + toString(root.left);
                result = result + ", "
                        + toString(root.right) + ")";
            }
        }

        return result;
    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        /*tree.root = new Node(12);
        tree.root.left = new Node(10);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(11);*/

        System.out.println(tree.insert(10));
        System.out.println(tree.insert(15));
        System.out.println(tree.insert(3));
        System.out.println(tree.insert(6));
        System.out.println(tree.insert(89));
        System.out.println(tree.insert(1));
        System.out.println(tree.insert(14));
        System.out.println(tree.insert(2));

        System.out.println(tree.find(1));
        System.out.println(tree.find(15));
        System.out.println(tree.find(100));
        System.out.println(tree.contains(100));
    }
}
