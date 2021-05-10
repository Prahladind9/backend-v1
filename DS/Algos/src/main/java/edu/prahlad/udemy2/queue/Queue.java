package edu.prahlad.udemy2.queue;

/**
 * Insert & Remove - O(1)
 * Search & Access - O(n)
 */
public class Queue<T> {
    Node<T> first;
    Node<T> last;
    int size;

    public Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public int enqueue(T val){
        Node newNode = new Node(val);
        if(this.size ==0){
            this.first = newNode;
            this.last = newNode;
        }else{
            this.last.next = newNode;
            this.last = newNode;
        }

        return ++this.size;

    }

    public Node dequeue(){
        if(this.size ==0) {
            return null;
        }

        if(this.first == this.last){
            this.last = null;
        }

        Node temp = this.first;
        this.first = this.first.next;
        this.size--;

        temp.next = null;
        return temp;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue("21");
        queue.enqueue("22");
        queue.enqueue("23");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
    }
}
