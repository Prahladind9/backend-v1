package edu.prahlad.java.course2.oop.solidPrinciples.liskovSubstitution.before;

public class ReadOnlyDocument extends Document {
    @Override
    public void save() throws Exception {
        throw new Exception("Can't save a read-only document");
    }
}
