package edu.prahlad.java.course2.oop.solidPrinciples.liskovSubstitution.after;

import java.util.List;

public class Project {
    private List<Document> allDocs;
    private List<WritableDocument> writableDocs;

    public void openAll(){
        allDocs.stream().forEach(document -> document.open());
    }

    public void saveAll(){
        writableDocs.stream().forEach(writableDocument -> writableDocument.save());
    }
}
