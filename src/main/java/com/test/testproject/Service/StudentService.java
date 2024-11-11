package com.test.testproject.Service;
import java.util.List;
import com.test.testproject.Model.Student;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    List<Student> getStudentByEnrolledYear(String year);
    Student updateStudent(Student student, Long id);
    void deleteStudent(long id);
    String getDepartmentNameByStudentId(Long studentId);
    void removeStudentsByEnrolmentYear(String year);
}
