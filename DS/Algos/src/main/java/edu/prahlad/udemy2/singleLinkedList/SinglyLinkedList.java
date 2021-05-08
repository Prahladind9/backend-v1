package edu.prahlad.udemy2.singleLinkedList;

import edu.prahlad.udemy2.dataStructures.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * BigO
 *
 * Insertion    O(1)
 * Removal      O(1) or O(n)
 * Searching    O(n)
 * Access       O(n)
 */
public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    //Adding a node to the end of the linked list!
    public SinglyLinkedList push(String val) {
        Node newNode = new Node(val);
        if (head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        length++;
        return this;
    }

    //Removing a node from the end of the LinkedList!
    public Node pop() {
        if (this.length == 0)
            return null;

        Node current = this.head;
        Node newTail = current;

        while (current.next != null) {
            newTail = current;
            current = current.next;
        }

        newTail.next = null;
        this.tail = newTail;
        length--;

        if (this.length == 0) {
            this.head = null;
            this.tail = null;
        }

        return current;
    }

    //Removing node from the beginning of the LinkedList!
    public Node shift() {
        if (this.length == 0)
            return null;

        Node currentHead = this.head;
        this.head = currentHead.next;
        this.length--;

        if (this.length == 0) {
            //this.head = null; //this step is not required as head is already removed
            this.tail = null;
        }

        return currentHead;
    }

    //Adding a new node to the beginning of the LinkedList!
    public SinglyLinkedList unShift(String val) {
        Node newNode = new Node(val);
        if (this.length == 0) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.length++;
        return this;
    }

    //Retrieving a node by it's position in the LinkedList!
    public Node get(int index) {
        if (validateIndex(index))
            return null;

        int counter = 0;
        Node current = this.head;
        while (counter != index) {
            current = current.next;
            counter++;
        }

        return current;
    }

    //Changing the value of a node based on it's position in the LinkedList!
    public boolean set(int index, String val) {
        Node foundNode = this.get(index);
        if (foundNode != null) {
            foundNode.val = val;
            return true;
        }

        return false;
    }

    //Adding a node to the LinkedList at a specific position
    public boolean insert(int index, String val) {
        if (validateIndex(index)) {
            return false;
        } else if (index == this.length) {
            this.push(val);
        } else if (index == 0) {
            this.unShift(val);
        } else {
            Node preNode = this.get(index - 1);

            Node newNode = new Node(val);
            newNode.next = preNode.next;

            preNode.next = newNode;
            this.length++;
        }
        return true;
    }

    //Removing a node from the LinkedList at a specific position
    public boolean remove(int index){
        if(index < 0 || index >= this.length) {
            return false;
        }else if(index == this.length-1){
            this.pop();
        }else if(index == 0){
            this.shift();
        }else{
            Node preNodeOfNodeToBeRemoved = this.get(index-1);
            Node nodeToBeRemoved = preNodeOfNodeToBeRemoved.next;
            preNodeOfNodeToBeRemoved.next = nodeToBeRemoved.next;
            this.length--;
        }
        return true;
    }

    //Reversing the LinkedList in place!
    public SinglyLinkedList reverse(){
        Node node = this.head;
        this.head = this.tail;
        this.tail = node;
        Node next;
        Node prev = null;
        for (int i = 0; i < this.length; i++) { //can use while as well
            next = node.next;
            node.next = prev;

            prev = node;
            node = next;
        }

        return this;
    }

    //Helper Methods
    private boolean validateIndex(int index) {
        return index < 0 || index > this.length;
    }

    private void print(){
        List<String> arr = new ArrayList<>();
        Node current = this.head;
        while(current != null){
            arr.add(current.val);
            current = current.next;
        }

        System.out.println(arr);
    }

    //Traverse through all nodes in the LinkedList!
    private void traverse() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        earlierSteps(singlyLinkedList);
        singlyLinkedList.print();
        singlyLinkedList.reverse();
        singlyLinkedList.print();
    }

    private static void earlierSteps(SinglyLinkedList singlyLinkedList) {
        populateSLL(singlyLinkedList);

        System.out.println(singlyLinkedList);
//        singlyLinkedList.traverse();

        System.out.println("Popped Node: " + singlyLinkedList.pop());
        System.out.println(singlyLinkedList);

        System.out.println("Popped Node: " + singlyLinkedList.pop());
        System.out.println(singlyLinkedList);

        System.out.println("Popped Node: " + singlyLinkedList.pop());
        System.out.println(singlyLinkedList);

        System.out.println("Popped Node: " + singlyLinkedList.pop());
        System.out.println(singlyLinkedList);

        populateSLL(singlyLinkedList);
        System.out.println("Shifted/Removed Node: " + singlyLinkedList.shift());
        System.out.println(singlyLinkedList);

        System.out.println("Shifted/Removed Node: " + singlyLinkedList.shift());
        System.out.println(singlyLinkedList);

        System.out.println("Shifted/Removed Node: " + singlyLinkedList.shift());
        System.out.println(singlyLinkedList);

        System.out.println("Shifted/Removed Node: " + singlyLinkedList.shift());
        System.out.println(singlyLinkedList);

        System.out.println("UnShifted Node: " + singlyLinkedList.unShift("Val"));
        System.out.println(singlyLinkedList);

        System.out.println("UnShifted Node: " + singlyLinkedList.unShift("Val2"));
        System.out.println(singlyLinkedList);

        System.out.println("GetNode: " + singlyLinkedList.get(1));
        System.out.println("GetNode: " + singlyLinkedList.get(20));
        System.out.println("GetNode: " + singlyLinkedList.get(-1));


        System.out.println(singlyLinkedList);
        System.out.println(singlyLinkedList.set(0, "Heyyo!"));
        System.out.println(singlyLinkedList.set(-1, "Heyyo!"));
        System.out.println(singlyLinkedList.set(120, "Heyyo!"));
        System.out.println(singlyLinkedList);


        populateSLL(singlyLinkedList);
        System.out.println(singlyLinkedList);
        singlyLinkedList.insert(2, "Two");
        System.out.println(singlyLinkedList);
        singlyLinkedList.remove(2);
        System.out.println(singlyLinkedList);

        System.out.println(singlyLinkedList.remove(20));
        System.out.println(singlyLinkedList.remove(-1));
    }

    private static void populateSLL(SinglyLinkedList singlyLinkedList) {
        singlyLinkedList.push("Hi");
        singlyLinkedList.push("there");
        singlyLinkedList.push("99");
    }
}
