package com.test.testproject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.testproject.Model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
