package edu.prahlad.codeWithMosh.part1.linkedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Second most used dataStructures next to array
 * Grow and shrink automatically
 * Take a bit more memory
 * Lookup
 *      By Index    O(n)
 *      By Value    O(n)
 * Insert
 *      Begin./End  O(1)
 *      Middle      O(n)
 * Delete
 *      Beginning   O(1)
 *      Middle      O(n)
 *      End         O(n) for Single, O(1) for DoubleLinkedList
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

    //addFirst
    public void addLast(final int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    //addLast
    public void addFirst(final int item) {
        var node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    //indexOf
    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    //contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    //removeFirst
    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    //removeLast
    public void removeLast() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    public int size() {
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        var index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }

        return array;
    }

    public void reverse(){
        // 10 -> 20 -> 30
        // 10 <- 20 <- 30
        //previous p, current c, next n

        if(isEmpty())
            return;

        var previous = first;
        var current = first.next;

        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int k){
        //2 pointer & the distance between 2 pointers should be k-1

        if(k <= 0 || k > size || isEmpty())
            throw new IllegalArgumentException();

        var pointerA = this.first;
        var pointerB = pointerA;
        for (int i = 0; i < k-1; i++) {
            pointerB = pointerB.next;
        }

        while (pointerB != last){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA.value;
    }

    private Node getPrevious(final Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }

        return null;
    }

    private boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    public static void main(String[] args) throws IllegalArgumentException{

        var linkedList = new LinkedList();
        System.out.println(linkedList.size());
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        System.out.println(linkedList);

        System.out.println(linkedList.getKthFromTheEnd(2));
        //System.out.println(linkedList.getKthFromTheEnd(20));
        System.out.println(linkedList.getKthFromTheEnd(0));

        linkedList.reverse();
        System.out.println(linkedList);


        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(linkedList.size());
        System.out.println(linkedList.indexOf(20));
        System.out.println(linkedList.indexOf(100));
        System.out.println(linkedList.contains(10));
        System.out.println(linkedList.contains(100));

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println(linkedList.size());




        /*java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.println(list);
        var array = list.toArray();
        System.out.println(Arrays.toString(array));*/
    }
}


