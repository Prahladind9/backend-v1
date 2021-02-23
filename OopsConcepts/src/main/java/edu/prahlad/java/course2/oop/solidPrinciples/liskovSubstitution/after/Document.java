package edu.prahlad.java.course2.oop.solidPrinciples.liskovSubstitution.after;

/**
 * After: the problem is solved after making the read-only document class
 * the base class of the hierarchy
 */
public class Document {
    public String data;
    public String fileName;

    public void open(){}
}
