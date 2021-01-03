package edu.prahlad.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class AscendingStudentComparator implements Comparator<Student>{
    @Override
    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getId(), student2.getId());
    }
}

public class StudentRunner {

    public static void main(String[] args) {
        List<Student> studentImmutableList = List.of(
                new Student(1, "Rao"),
                new Student(10, "Adam"),
                new Student(21, "Oliver"),
                new Student(671, "Ted")
                );

        List<Student> studentsAl = new ArrayList<>(studentImmutableList);

        Collections.sort(studentsAl);
        System.out.println("Desc " + studentsAl);

        Collections.sort(studentsAl, new AscendingStudentComparator());
        System.out.println("AscendingStudentComparator " + studentsAl);

        studentsAl.sort(new AscendingStudentComparator());
        System.out.println("AscendingStudentComparator " + studentsAl);
    }
}
