package edu.prahlad.codeWithMosh3.part1.stack;

import java.util.Arrays;

/**
 * Last-In-First-Out (LIFO) dataStructure
 * Can be implemented via array/arraylist
 *
 * Time & Space O(1)
 */
public class Stack {

    private int[] items = new int[5];
    private int count = 0;

    public void push(int item){
        if(count == items.length)
            throw new StackOverflowError();

        items[count++] = item;
    }

    public int pop(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[count -1];
    }

    public boolean isEmpty(){
        return count ==0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, count);
        return "Stack{" +
                "items=" + Arrays.toString(content) +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        //stack.pop();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
