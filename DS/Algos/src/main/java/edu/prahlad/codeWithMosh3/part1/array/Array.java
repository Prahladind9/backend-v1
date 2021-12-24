package edu.prahlad.codeWithMosh3.part1.array;

import java.util.ArrayList;

public class Array {
    int[] items;
    int count = 0;

    public Array(int count) {
        this.items = new int[count];
    }

    public void insert(final int item) {
        //check array size
        if(items.length == count){
            int[] itemsTemp = new int[items.length * 2];
            for (int i = 0; i < items.length; i++) {
                itemsTemp[i] = items[i];
            }
            items = itemsTemp;
        }
        items[count] = item;
        count++;
    }

    public void removeAt(final int index) {
        //valid index
        if(index <0 || index >= count){
            throw new IllegalArgumentException("Invalid Index");
        }

        for (int i = index; i < count-1; i++) {
            items[i] = items[i+1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if(items[i] == item) return i;
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
