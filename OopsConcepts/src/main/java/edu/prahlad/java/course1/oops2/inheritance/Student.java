package edu.prahlad.java.course1.oops2.inheritance;

public class Student extends Person{
    //Is a relationship
    private String collegeName;
    private int year;

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
