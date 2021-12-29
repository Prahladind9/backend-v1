package edu.prahlad.codeWithMosh3.part1.linkedList;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class LinkedList {
    private class Node{
        public int value;
        public Node next;

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

    //addFirst;
    public void addFirst(int item){
        var newNode = new Node(item);
        if(isEmpty()){
            first = last = newNode;
        }else {
            newNode.next = first;
            first = newNode;
        }
        size++;
    }

    //addLast
    public void addLast(int item){
        var newNode = new Node(item);
        if(isEmpty()){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while (current != null){
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    //contains
    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    //removeFirst
    public void removeFirst(){
        if(isEmpty()) throw new NoSuchElementException();
        if(hasOneElement()) {
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    //deleteLast
    public void removeLast(){
        if(isEmpty()) throw new NoSuchElementException();
        if(hasOneElement()){
            first = last = null;
        }else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }

        size--;
    }

    public void reverse(){
        if(isEmpty() || hasOneElement()) return;

        Node previous = null;
        var current = first;
        while (current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        last = first;
        first = previous;
    }

    public int getKthFromTheEnd(int k){
        if(isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;
        for (int i = 0; i < k -1; i++) {
            b = b.next;
            if(b == null)  throw new IllegalArgumentException();
        }

        while (b != last){
            a = a.next;
            b = b.next;
        }
        
        return a.value;
    }

    private Node getPrevious(Node node){
        var current = first;
        while (current != null){
            if(current.next == node) return current;
            current = current.next;
        }

        return null;
    }

    public int[] toArray(){
        int[] result = new int[size];
        Node current = first;
        var index = 0;
        while (current != null){
            result[index++] = current.value;
            current = current.next;
        }
        return result;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private boolean hasOneElement() {
        return first == last;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) throws IllegalArgumentException{

        var linkedList = new LinkedList();
        System.out.println(linkedList.size());
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addLast(40);
        linkedList.addLast(50);
        linkedList.addFirst(10);
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(linkedList.indexOf(20));
        System.out.println(linkedList.indexOf(100));
        System.out.println(linkedList.contains(40));
        System.out.println(linkedList.contains(100));

        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
        System.out.println(linkedList.size());
        System.out.println(Arrays.toString(linkedList.toArray()));
        linkedList.reverse();
        System.out.println(linkedList);

        System.out.println(linkedList.getKthFromTheEnd(2));
        System.out.println(linkedList.getKthFromTheEnd(0));
        System.out.println(linkedList.getKthFromTheEnd(20));

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
