package edu.prahlad.java.course1.oops2.interfaces;

public class RealAlgorithm implements ComplexAlgorithm{
    @Override
    public int complexAlgorithm(int number1, int number2) {
        return number1 * number2;
    }
}
