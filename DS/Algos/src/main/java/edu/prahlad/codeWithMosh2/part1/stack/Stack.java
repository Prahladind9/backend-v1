package edu.prahlad.codeWithMosh2.part1.stack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Stack is a Last-In First-Out (LIFO) dataStructure
 * Stack can be implemented using Arrays/LinkedLists
 *
 * All operations run in O(1)
 */
public class Stack {
    static class StackArray{
        private Integer[] items;
        private int size;

        public StackArray(int initializeSize) {
            this.items = new Integer[initializeSize];
            this.size = 0;
        }

        public void push(int val) {
            if(size == items.length) {
                items = incrementedArray();
            }

            items[size] = val;
            size++;
        }

        private Integer[] incrementedArray(){
            Integer[] temp = new Integer[items.length * 2];
            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }

            return temp;
        }

        public Integer pop() {
            if(isEmpty())
                throw new IllegalStateException();

            return items[--size];
        }

        public Integer peek() {
            if(isEmpty())
                throw new IllegalStateException();

            return items[size - 1];
        }

        public boolean isEmpty(){
            return size == 0;
        }

        @Override
        public String toString() {
            var content = Arrays.copyOfRange(items, 0, size);
            return "Stack{" +
                    "items=" + Arrays.toString(content) +
                    ", size=" + size +
                    '}';
        }
    }

    static class StackLinkedList{
        private LinkedList<Integer> items = new LinkedList<>();

        public void push(int val) {
            items.push(val);
        }

        public Integer pop() {
            if(items.isEmpty())
                throw new IllegalStateException();

            return items.removeFirst();
        }

        public Integer peek() {
            if(items.isEmpty())
                throw new IllegalStateException();

            return items.peekFirst();
        }

        @Override
        public String toString() {
            return "StackLinkedList{" +
                    "items=" + items +
                    '}';
        }
    }

    public static void main(String[] args) {
        //Stack
        //push
        //pop
        //peek
        //isEmpty
        //int[]

//        StackArray stack = new StackArray(0);
        StackLinkedList stack = new StackLinkedList();
        //stack.pop();
        stack.push(10);
        System.out.println(stack);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }
}
