package edu.prahlad.codeWithMosh2.part1.array;

public class Array {
    private int[] array;
    private int count;

    public Array(int length) {
        this.array = new int[length];
    }

    public void insert(int item){
        if(array.length == count){
            int[] newArray = new int[count*2];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }

        array[count++] = item;
    }

    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(2);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.print();
    }
}
