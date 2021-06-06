package edu.prahlad.java.course2.inheritancePolymorphism;

public class CheckBox extends UIControl{
    public CheckBox() {
        super(true);
    }

    @Override
    public void render() {
        System.out.println("Render Checkbox");
    }
}