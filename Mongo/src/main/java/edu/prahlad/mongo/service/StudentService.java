package edu.prahlad.mongo.service;

import edu.prahlad.mongo.entiity.Student;
import edu.prahlad.mongo.repo.DepartmentRepo;
import edu.prahlad.mongo.repo.StudentRepo;
import edu.prahlad.mongo.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepository;
    @Autowired
    private DepartmentRepo departmentRepository;
    @Autowired
    private SubjectRepo subjectRepository;

    public Student createStudent (Student student) {
        //return studentRepository.save(student);//For Embedded Documents

        if(student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }

        if(student.getSubjects() != null && student.getSubjects().size() > 0){
            subjectRepository.saveAll(student.getSubjects());
        }

        return studentRepository.save(student);
    }

    public Student getStudentbyId(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent (Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent (String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted.";
    }

    public List<Student> getStudentsByName (String name) {
        //return studentRepository.findByName(name);
        return studentRepository.getByName(name);
    }

    public Student studentsByNameAndMail (String name, String email) {
        return studentRepository.findByEmailAndName(email, name);
    }

    public Student studentsByNameOrMail (String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination (int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> allWithSorting () {
        Sort sort = Sort.by(Sort.Direction.ASC, "name", "email");

        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName (String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName (String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike (String email) {
        return studentRepository.findByEmailIsLike(email);
    }

    public List<Student> nameStartsWith (String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
