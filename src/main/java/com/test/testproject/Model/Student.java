package com.test.testproject.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String stdEmail;
    private String stdDepartment;
    private String yearOfEnrolment;

    public Long getStdId() {
        return stdId;
    }

    public void setStdId(Long stdId) {
        this.stdId = stdId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStdEmail() {
        return stdEmail;
    }

    public void setStdEmail(String stdEmail) {
        this.stdEmail = stdEmail;
    }

    public String getStdDepartment() {
        return stdDepartment;
    }

    public void setStdDepartment(String stdDepartment) {
        this.stdDepartment = stdDepartment;
    }

    public String getYearOfEnrolment() {
        return yearOfEnrolment;
    }

    public void setYearOfEnrolment(String yearOfEnrolment) {
        this.yearOfEnrolment = yearOfEnrolment;
    }
}
