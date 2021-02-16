package edu.prahlad.java.course2.oop.designPrinciples.favorCompositionOverInheritance.after_compositon;

public class CombustionEngine implements Engine{
    @Override
    public void move() {
        System.out.println("CombustionEngine move call");
    }
}
