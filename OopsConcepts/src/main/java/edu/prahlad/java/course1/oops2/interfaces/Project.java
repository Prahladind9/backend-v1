package edu.prahlad.java.course1.oops2.interfaces;

public class Project {
    public static void main(String[] args) {
        ComplexAlgorithm algorithm = new RealAlgorithm();
        System.out.println(algorithm.complexAlgorithm(1,10));
    }
}