package edu.prahlad.java.arrays;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;

public class Student2 {

    private String name;
    private ArrayList<Integer> marks = new ArrayList<>(); //Refactor

    public Student2(String name, int... marks) {
        this.name = name;
        for(int mark: marks) {
            this.marks.add(mark);
        }
    }

    public int getNumberOfMarks() {
        return this.marks.size();
    }

    public int getTotalSumOfMarks() {
        int sum = 0;
        for (int mark :marks) {
            sum += mark;
        }
        return sum;
    }

    public int getMaximumMark() {
        return Collections.max(marks);
    }

    public int getMinimumMark() {
        return Collections.min(marks);
    }

    public BigDecimal getAverageMarks() {
        int sum = getTotalSumOfMarks();
        int number = getNumberOfMarks();

        return new BigDecimal(sum).divide(new BigDecimal(number), 3, RoundingMode.UP);
        //RoundingMode with precision
    }

    public void addNewMark(int mark) {
        marks.add(mark);
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }


    public void removeMarkAtIndex(int index) {
        marks.remove(index);
    }
}
