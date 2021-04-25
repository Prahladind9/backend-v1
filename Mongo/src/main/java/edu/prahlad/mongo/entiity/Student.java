package edu.prahlad.mongo.entiity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
@Document(collection = "student")
public class Student {

    @Id
    private String id;
    private String name;
    @Field(name = "mail")
    private String email;
    private Department department;
    private List<Subject> subjects;
}
