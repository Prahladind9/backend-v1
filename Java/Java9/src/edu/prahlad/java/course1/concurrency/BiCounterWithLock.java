package edu.prahlad.java.course1.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BiCounterWithLock {
    private int i = 0;
    private int j = 0;

    Lock lockForI = new ReentrantLock();
    Lock lockForJ = new ReentrantLock();

    public void incrementI(){
        lockForI.lock();//Get Lock for I
        i++;
        lockForI.unlock();//Release Lock for I

    }

    synchronized public void incrementJ(){
        lockForJ.lock();//Get Lock for J
        j++;
        lockForJ.unlock();//Release Lock for J
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
