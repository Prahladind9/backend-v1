package edu.prahlad.java.course2.oop.designPrinciples.favorCompositionOverInheritance.after_compositon;

public class Human implements Driver{
    @Override
    public void navigate() {
        System.out.println("Human navigate call");
    }
}
