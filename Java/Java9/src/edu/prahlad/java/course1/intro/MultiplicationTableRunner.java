package edu.prahlad.java.course1.intro;

public class MultiplicationTableRunner {
    public static void main(String[] args) {
//        MultiplicationTable multiplicationTable = new MultiplicationTable();
        MultiplicationTableRefactored multiplicationTable = new MultiplicationTableRefactored();
        multiplicationTable.print();
        multiplicationTable.print(9);
        multiplicationTable.print(16,11,20);
    }
}
