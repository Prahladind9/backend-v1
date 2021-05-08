package edu.prahlad.udemy2.doublyLinkedList;

/**
 * Insertion    O(1)
 * Removal      O(1)
 * Access       O(n)
 * Searching    O(n) - technically searching is O(n/2), but that's still O(n)
 */
public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int length;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    //Adding a node to the end of the Doubly Linked List
    public DoublyLinkedList push(String val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        this.length++;
        return this;
    }

    //Removing a node from the end of the DoublyLinkedList
    public Node pop() {
        if (this.length == 0) {
            return null;
        }
        Node poppedNode = this.tail;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            poppedNode.prev = null;
        }

        this.length--;
        return poppedNode;
    }

    //Removing a node from the beginning of the DoublyLinkedList
    public Node shift() {
        if (this.length == 0) {
            return null;
        }
        Node oldHead = this.head;
        if (this.length == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = oldHead.next;
            this.head.prev = null;
            oldHead.next = null;
        }

        this.length--;
        return oldHead;
    }

    //Adding a node to the beginning of the DoublyLinkedList
    public DoublyLinkedList unShift(String val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.prev = newNode;
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
        return this;
    }

    //Accessing a node in a DoublyLinkedList by its position
    public Node get(int index) {
        if (index < 0 || index >= this.length) {
            return null;
        }

        if (index <= this.length / 2) {
            int counter = 0;
            Node current = this.head;
            while (counter != index) {
                counter++;
                current = current.next;
            }
            return current;
        } else {
            int counter = this.length - 1;
            Node tail = this.tail;
            while (counter != index) {
                counter--;
                tail = tail.prev;
            }

            return tail;
        }
    }

    //Replacing the value of a node to the given value in a DLL
    public boolean set(int index, String val) {
        Node foundNode = this.get(index);
        if (foundNode != null) {
            foundNode.val = val;
            return true;
        }
        return false;
    }

    //Adding a node in a DLL by a certain position
    public boolean insert(int index, String val) {
        if (index < 0 || index > this.length) {
            return false;
        }

        if (index == 0) {
            this.unShift(val);
        } else if (index == this.length) {
            this.push(val);
        } else {
            Node newNode = new Node(val);
            Node beforeNode = this.get(index - 1);
            Node afterNode = beforeNode.next;

            beforeNode.next = newNode;
            newNode.prev = beforeNode;
            newNode.next = afterNode;
            afterNode.prev = newNode;

            this.length++;
        }

        return true;
    }

    //Removing a node in a DoublyLinkedList
    public Node remove(int index) {
        if (index < 0 || index >= this.length)
            return null;

        if (index == 0) {
            return this.shift();
        } else if (index == this.length - 1) {
            return this.pop();
        } else {

            Node removedNode = this.get(index);
            Node beforeNode = removedNode.prev;
            Node afterNode = removedNode.next;
            beforeNode.next = afterNode;
            afterNode.prev = beforeNode;
//            removedNode.prev.next = removedNode.next;
//            removedNode.next.prev = removedNode.prev;

            removedNode.next = null;
            removedNode.prev = null;
            this.length--;
            return removedNode;
        }


    }

    @Override
    public String toString() {
        return "DoublyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        earlierSteps(doublyLinkedList);
        System.out.println(doublyLinkedList);
        System.out.println(doublyLinkedList.remove(0));
        System.out.println(doublyLinkedList.remove(3));
        System.out.println(doublyLinkedList);
    }


    private static void earlierSteps(DoublyLinkedList doublyLinkedList) {
        populateDLL(doublyLinkedList);
        System.out.println(doublyLinkedList);
        doublyLinkedList.pop();
        System.out.println(doublyLinkedList);
        doublyLinkedList.shift();
        doublyLinkedList.pop();
        doublyLinkedList.pop();
        doublyLinkedList.pop();
        doublyLinkedList.unShift("90");
        populateDLL(doublyLinkedList);
        System.out.println(doublyLinkedList.get(3));
        System.out.println(doublyLinkedList.get(9));
        System.out.println(doublyLinkedList.get(-1));

        doublyLinkedList.set(0, "88");
        doublyLinkedList.set(10, "88");

        System.out.println(doublyLinkedList);
        doublyLinkedList.insert(2, "100");
        doublyLinkedList.insert(0, "80");
        System.out.println(doublyLinkedList);
        doublyLinkedList.insert(3, "79");
        doublyLinkedList.insert(7, "129");

    }

    private static void populateDLL(DoublyLinkedList doublyLinkedList) {
        doublyLinkedList.push("91");
        doublyLinkedList.push("92");
        doublyLinkedList.push("93");
    }
}
