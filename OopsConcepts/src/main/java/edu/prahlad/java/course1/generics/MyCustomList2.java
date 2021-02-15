package edu.prahlad.java.course1.generics;

import java.util.ArrayList;

public class MyCustomList2<T extends Number> {
    ArrayList<T> list = new ArrayList<>();

    public void addElement(T element){
        list.add(element);
    }

    public void removeElements(T element){
        list.remove(element);
    }

    @Override
    public String toString() {
        return "MyCustomList{" +
                "list=" + list +
                '}';
    }

    public T get(int index) {
        return list.get(index);
    }
}
