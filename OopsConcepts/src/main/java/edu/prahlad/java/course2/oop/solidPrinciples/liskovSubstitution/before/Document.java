package edu.prahlad.java.course2.oop.solidPrinciples.liskovSubstitution.before;

/**
 * Before: Saving ReadOnlyDocument doesn't make sense in a read-only document,
 * so the subclass tries to solve it by resetting the base behaviour in the
 * overridden method.
 */
public class Document {
    public String data;
    public String fileName;

    public void open(){}
    public void save() throws Exception {}
}
