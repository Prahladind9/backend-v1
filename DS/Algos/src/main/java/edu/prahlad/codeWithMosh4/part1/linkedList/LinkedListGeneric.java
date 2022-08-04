package edu.prahlad.codeWithMosh4.part1.linkedList;

import java.util.NoSuchElementException;

public class LinkedListGeneric<T> {
    private class Node<T>{
        public T value;
        public Node<T> next;

        public Node(T value) {
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
    public void addFirst(T item){
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
    public void addLast(T item){
        var newNode = new Node(item);
        if(isEmpty()){
            first = last = newNode;
        }else{
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public int indexOf(T item){
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
    public boolean contains(T item){
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

    public T getKthFromTheEnd(int k){
        if(isEmpty()) throw new IllegalStateException();

        Node<T> a = first;
        Node<T> b = first;
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

        var linkedList = new LinkedListGeneric<Integer>();
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
        linkedList.reverse();
        System.out.println(linkedList);

        System.out.println(linkedList.getKthFromTheEnd(2));
        System.out.println(linkedList.getKthFromTheEnd(0));
        //System.out.println(linkedList.getKthFromTheEnd(20));
    }
}
