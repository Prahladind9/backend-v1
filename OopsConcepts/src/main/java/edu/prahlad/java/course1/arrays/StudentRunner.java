package edu.prahlad.java.course1.arrays;

import java.math.BigDecimal;

public class StudentRunner {

    public static void main(String[] args) {

//        Student student = new Student("Rao", new int[]{97,98, 100});
//        try using variable arguments
        Student2 student = new Student2("Rao", 97,98, 100);

        int number = student.getNumberOfMarks();
        System.out.println("No of marks: "+ number);

        int sum = student.getTotalSumOfMarks();
        System.out.println("Sum of marks: "+ sum);

        int maximumMark = student.getMaximumMark();
        System.out.println("MaximumMark: "+ maximumMark);

        int minimumMark = student.getMinimumMark();
        System.out.println("Minimum Mark: "+ minimumMark);

        BigDecimal average = student.getAverageMarks();
        System.out.println("Average Marks: "+ average);

        System.out.println(student);

        student.addNewMark(35);
        System.out.println(student);

        student.removeMarkAtIndex(1);
        System.out.println(student);
    }
}
