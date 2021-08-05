package edu.prahlad.codeWithMosh2.part1.array;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }

    public void insert(int item) {
        if (items.length == count) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }

        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count - 1; i++) {
            items[i] = items[i + 1];
        }

        count--;
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
            if(items[i] == item)
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
        array.removeAt(3);
        System.out.println(":)  " + array.indexOf(30));
        array.print();
    }
}
