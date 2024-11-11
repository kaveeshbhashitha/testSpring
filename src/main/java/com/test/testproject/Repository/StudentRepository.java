package com.test.testproject.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.test.testproject.Model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByYearOfEnrolment(String enrolledYear);
    @Query("SELECT s.stdDepartment FROM Student s WHERE s.stdId = :studentId")
    String findDepartmentNameByStudentId(@Param("studentId") Long studentId);

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.yearOfEnrolment = :year")
    void deleteStudentsByEnrolmentYear(@Param("year") String year);
}
