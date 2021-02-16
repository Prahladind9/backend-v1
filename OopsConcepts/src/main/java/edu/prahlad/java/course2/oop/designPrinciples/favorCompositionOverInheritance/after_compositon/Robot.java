package edu.prahlad.java.course2.oop.designPrinciples.favorCompositionOverInheritance.after_compositon;

public class Robot implements Driver{
    @Override
    public void navigate() {
        System.out.println("Robot navigate call");
    }
}
