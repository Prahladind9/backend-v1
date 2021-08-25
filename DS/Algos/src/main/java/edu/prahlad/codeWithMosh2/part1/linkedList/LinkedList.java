package edu.prahlad.codeWithMosh2.part1.linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Lookup
 *      By Value O(n)
 *      By Index O(n)
 *
 *  Insert
 *      At the End O(1)
 *      At the Start O(1)
 *      In the Middle O(n)
 *
 *  Delete
 *      At the End O(n)
 *      At the Start O(1)
 *      In the Middle O(n)
 */
public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    private Node first;
    private Node last;
    private int size;

    public int size(){
        return size;
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    //addFirst
    public void addFirst(int value){
        var newNode = new Node(value);
        if(isEmpty()){
            this.first = newNode;
            this.last = this.first;
        }else {
            newNode.next = first;
            first = newNode;
        }

        size++;
    }
    //addLast
    public void addLast(int value){
        Node newNode = new Node(value);

        if(isEmpty()){
            this.first = newNode;
            this.last = this.first;
        }else {
            this.last.next = newNode;
            this.last = newNode;
        }

        size++;
    }
    //deleteFirst
    public void deleteFirst(){
        if(isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last = null;
        }else {

            Node second = this.first.next;
            this.first.next = null;
            first = second;
        }

        size--;
    }
    //deleteLast
    public void deleteLast(){
        if (isEmpty()) throw new NoSuchElementException();

        if(first == last){
            first = last = null;

        }else {
//        Node newLastNode = getNodeAtIndex(size()-1); or
            Node newLastNode = getPrevious(this.last);
            newLastNode.next = null;
            this.last = newLastNode;
        }
        size--;
    }
    //contains
    public boolean contains(int value){
       return indexOf(value) != -1;
    }

    //indexOf
    public int indexOf(int value){
        Node temp = this.first;
        for (int i = 1; i <= size; i++) {
            if(temp.value == value) return i;
            temp = temp.next;
        }
        return -1;
    }

    private Node getPrevious(Node node){
        var current = first;
        while (current !=null){
            if(current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private Node getNodeAtIndex(int index){
        Node temp = this.first;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public int[] toArray(){
        int[] array = new int[size()];
        Node current = first;
        for (int i = 0; i < size(); i++) {
            array[i] = current.value;
            current = current.next;
        }

        return array;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    private void print(){
        System.out.println(this);
    }

    public static void main(String[] args) {
        var linkedList = new LinkedList();
        linkedList.addFirst(30);
        linkedList.addFirst(20);
        linkedList.addFirst(10);
        linkedList.addFirst(5);
        linkedList.addLast(40);
        linkedList.print();

        linkedList.deleteFirst();
        linkedList.print();

        linkedList.deleteLast();
        linkedList.print();

        System.out.println(linkedList.contains(20));
        System.out.println(linkedList.contains(30));
        System.out.println(linkedList.contains(90));

        System.out.println(linkedList.indexOf(20));
        System.out.println(linkedList.indexOf(90));

        System.out.println(Arrays.toString(linkedList.toArray()));
    }
}