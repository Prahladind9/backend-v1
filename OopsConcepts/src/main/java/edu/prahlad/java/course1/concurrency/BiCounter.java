package edu.prahlad.java.course1.concurrency;

public class BiCounter {

    private int i = 0;
    private int j = 0;

    synchronized public void incrementI(){ i++; }
    synchronized public void incrementJ(){ j++; }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
