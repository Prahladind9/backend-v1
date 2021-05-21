package edu.prahlad.CodeWithMosh.part1.array;

import java.util.ArrayList;

/**
 * Simplest dataStructure
 * Static (Array) vs dynamic (ArrayList)
 * Best if we know the size beforehand
 *
 * Lookup by Index O(1)
 * Lookup by Value O(n)
 *          Insert O(n)
 *          Delete O(n)
 */
public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(final int item) {
        //If the array is full, resize it
        if (items.length == count) {
            //create a new array (twice the size)
            int[] newItems = new int[count * 2];
            //Copy all the existing items
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            //Set "items" to this new array
            items = newItems;
        }
        //Add the new item at the end
        items[count] = item;
        count++;
    }

    public void removeAt(final int index) {
        //Validate the index
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        //Shift the items to the left to fill the hole
        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }
        //decrement the size
        count--;
    }

    public int indexOf(int item) {
        //loop all items, if we find it, return index
        //Otherwise, return -1
        for (int i = 0; i < count; i++) {
            if (items[i] == item)
                return i;
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }


    public static void main(String[] args) {
        Array array = new Array(2);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.removeAt(1);
        System.out.println(array.indexOf(30));
        System.out.println(array.indexOf(60));
        array.print();

        //Existing Java Array Class
        //Vector: grows by 100% - synchronized methods
        //ArrayList: grows by 50% - wrapper class are used

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(40);
        list.remove(1);
        System.out.println("first Index: " + list.indexOf(20));
        System.out.println("first Index: " + list.indexOf(40));
        System.out.println("lastIndexOf: " + list.lastIndexOf(40));
        System.out.println(list.size());
        System.out.println(list.toArray());
        System.out.println(list);
    }
}
