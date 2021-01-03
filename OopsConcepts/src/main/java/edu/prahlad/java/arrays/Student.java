package edu.prahlad.java.arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Student {

    private final int[] marks;
    private final String name;

    /*public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }*/

    //Using Variable arguments
    //Note: Variable argument - must be last argument of the method
    public Student(String name, int... marks) {
        this.name = name;
        this.marks = marks;
    }

    public int getNumberOfMarks() {
        return this.marks.length;
    }

    public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark :marks) {
            sum += mark;
        }
        return sum;
    }

    public int getMaximumMark() {
        int maximum = Integer.MIN_VALUE;
        for(int mark: marks){
            if(mark>maximum){
                maximum = mark;
            }
        }
        return maximum;
    }

    public int getMinimumMark() {
        int minimum = Integer.MAX_VALUE;
        for(int mark: marks){
            if(mark<minimum){
                minimum = mark;
            }
        }
        return minimum;
    }

    public BigDecimal getAverageMarks() {
        int sum = getTotalSumOfMarks();
        int number = getNumberOfMarks();

        return new BigDecimal(sum).divide(new BigDecimal(number), 3, RoundingMode.UP);
        //RoundingMode with precision
    }
}
