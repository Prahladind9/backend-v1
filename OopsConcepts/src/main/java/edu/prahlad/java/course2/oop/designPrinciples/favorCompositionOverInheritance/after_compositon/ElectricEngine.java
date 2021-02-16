package edu.prahlad.java.course2.oop.designPrinciples.favorCompositionOverInheritance.after_compositon;

public class ElectricEngine implements Engine{
    @Override
    public void move() {
        System.out.println("ElectricEngine move call");
    }
}
