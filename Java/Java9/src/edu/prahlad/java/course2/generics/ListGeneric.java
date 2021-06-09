package edu.prahlad.java.course2.generics;

import java.io.Closeable;

public class ListGeneric<T> {
    private T[] items = (T[]) new Object[10];
    private int count;

    public void add(T item){
        items[count++] = item;
    }

    public T get(int index){
        return items[index];
    }
}
