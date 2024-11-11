package com.test.testproject.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.testproject.Model.Student;
import com.test.testproject.Repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    //save student in database
    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    //get all student form database
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    //get student using id
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public List<Student> getStudentByEnrolledYear(String year) {
        return studentRepository.findByYearOfEnrolment(year);
    }
    //update student
    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingstudent = studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        existingstudent.setFirstName(student.getFirstName());
        existingstudent.setLastName(student.getLastName());
        existingstudent.setStdEmail(student.getStdEmail());
        // save
        studentRepository.save(existingstudent);
        return existingstudent;
    }
    @Override
    public void deleteStudent(long id) {
        throw new UnsupportedOperationException("Unimplemented method 'delete student'");
    }

    @Override
    public String getDepartmentNameByStudentId(Long studentId) {
        // Call repository method to get the department name
        return studentRepository.findDepartmentNameByStudentId(studentId);
    }

    @Override
    public void removeStudentsByEnrolmentYear(String year) {
        studentRepository.deleteStudentsByEnrolmentYear(year);
    }
}
