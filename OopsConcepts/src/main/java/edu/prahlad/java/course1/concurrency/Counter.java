package edu.prahlad.java.course1.concurrency;

public class Counter {
    private int i = 0;

    //is not thread safe
    /*public void incrementer(){
        i++;
    }*/

    synchronized public void incrementer(){
        i++;
    }

    public int getI() {
        return i;
    }

}
