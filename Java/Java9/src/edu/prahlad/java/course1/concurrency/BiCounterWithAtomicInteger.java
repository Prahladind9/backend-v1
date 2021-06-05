package edu.prahlad.java.course1.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class BiCounterWithAtomicInteger {
    private AtomicInteger i = new AtomicInteger();
    private AtomicInteger j = new AtomicInteger();


    public void incrementI(){
        i.incrementAndGet();
    }

    synchronized public void incrementJ(){
        j.incrementAndGet();
    }

    public int getI() {
        return i.get();
    }

    public int getJ() {
        return j.get();
    }
}
