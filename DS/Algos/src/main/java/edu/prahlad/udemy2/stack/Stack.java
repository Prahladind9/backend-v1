package edu.prahlad.udemy2.stack;

/**
 * Insertion & Removal O(1)
 * Searching & Access - O(n)
 *
 */
public class Stack<T> {
    public Node<T> first;
    public Node<T> last;
    public int size;

    public Stack() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int push(String val){
        Node newNode = new Node(val);
        if(this.first== null){
            this.first = newNode;
            this.last = newNode;
        }else{
            Node temp = this.first;
            this.first = newNode;
            this.first.next = temp;
        }

        return ++this.size;
    }

    public Node pop(){
        if(this.size ==0) {
            return null;
        }
        Node temp = this.first;
        if(this.first == this.last){
            this.last = null;
        }
        this.first = this.first.next;
        this.size--;
        return temp;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("21");
        stack.push("22");
        stack.push("23");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
