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
    //update student
    @Override
    public Student updateStudent(Student student, Long id) {
        Student existingstudent =
        studentRepository.findById(id).orElseThrow(()-> new RuntimeException());
        existingstudent.setFirstName(student.getFirstName());
        existingstudent.setLastName(student.getLastName());
        existingstudent.setStdEmail(student.getStdEmail());
        // save
        studentRepository.save(existingstudent);
        return existingstudent;
    }
    @Override
    public void deleteStudent(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletestudent'");
    }
}
