package com.test.testproject.Controller;
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

import java.util.List;

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

    // StudentController.java

    @GetMapping("/getByYear/{year}")
    public ResponseEntity<List<Student>> getStudentByEnrollYear(@PathVariable("year") String year){
        List<Student> students = studentService.getStudentByEnrolledYear(year);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/getByDepartment/{studentId}")
    public ResponseEntity<String> getDepartmentByStudentId(@PathVariable("studentId") Long studentId) {
        String departmentName = studentService.getDepartmentNameByStudentId(studentId);
        if (departmentName != null) {
            return ResponseEntity.ok(departmentName);
        } else {
            return ResponseEntity.notFound().build();
        }
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
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
    //delete employee from db
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Employee deleted Successfully.",HttpStatus.OK);
    }

    @DeleteMapping("/deleteByYear/{year}")
    public ResponseEntity<String> removeStudentsByEnrolmentYear(@PathVariable("year") String year) {
        studentService.removeStudentsByEnrolmentYear(year);
        return ResponseEntity.ok("Students enrolled in " + year + " have been deleted.");
    }
 }

