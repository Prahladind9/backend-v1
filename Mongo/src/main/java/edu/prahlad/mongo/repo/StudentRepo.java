package edu.prahlad.mongo.repo;

import edu.prahlad.mongo.entiity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends MongoRepository<Student, String> {

    List<Student> findByName(String name);

    Student findByEmailAndName (String email, String name);

    Student findByNameOrEmail (String name, String email);

    List<Student> findByDepartmentDepartmentName(String deptName);//only works for Embedded Doc

    List<Student> findBySubjectsSubjectName (String subName);//only works for Embedded Doc

    List<Student> findByEmailIsLike (String email);

    List<Student> findByNameStartsWith (String name);

    List<Student> findByDepartmentId(String deptId);

    @Query("{ \"name\" : \"?0\" }")//0 - first param .. viz
    List<Student> getByName(String name);
}
