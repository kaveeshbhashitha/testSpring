package com.test.testproject.Service;
import java.util.List;
import com.test.testproject.Model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student updateStudent(Student student,Long id);
    void deleteStudent(long id);
}
