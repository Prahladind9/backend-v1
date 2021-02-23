package edu.prahlad.java.course2.oop.solidPrinciples.liskovSubstitution.before;

import java.util.List;

public class Project {
    public List<Document> documentList;

    public void openAll() throws Exception {
        for(Document document: documentList){
            if(!(document instanceof ReadOnlyDocument)){
                document.save();
            }
        }
    }
}
