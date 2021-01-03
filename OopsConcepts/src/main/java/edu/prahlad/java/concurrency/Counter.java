package edu.prahlad.java.concurrency;

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
