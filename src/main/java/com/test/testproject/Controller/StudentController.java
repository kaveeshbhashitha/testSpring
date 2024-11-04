package com.test.testproject.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.testproject.Model.Student;
import com.test.testproject.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new
        ResponseEntity<Student>(studentService.saveStudent(student),
        HttpStatus.CREATED);
    }
    //GetAll Rest Api
    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    //Get by Id Rest Api
    @GetMapping("/getById/{id}")
    public ResponseEntity<Student> getEmployeeById(@PathVariable("id") Long studentId){
        return new ResponseEntity<Student>(studentService.getStudentById(studentId),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId, @RequestBody Student student) {
        try {
            Student updatedStudent = studentService.updateStudent(student, studentId);
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long
    id){
    //delete employee from db
    studentService.deleteStudent(id);
    return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }
 }

