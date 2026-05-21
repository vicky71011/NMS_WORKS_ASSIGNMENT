package com.studentresult.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    @Column(name = "student_name", nullable = false)
    private String studentName;

    @NotBlank(message = "Roll number is required")
    @Column(name = "roll_number", unique = true, nullable = false)
    private String rollNumber;

    @NotBlank(message = "Department is required")
    @Column(name = "department", nullable = false)
    private String department;

    @NotBlank(message = "Subject is required")
    @Column(name = "subject", nullable = false)
    private String subject;

    @Min(value = 0, message = "Marks cannot be less than 0")
    @Max(value = 100, message = "Marks cannot exceed 100")
    @Column(name = "marks_obtained", nullable = false)
    private int marksObtained;

    @Column(name = "total_marks", nullable = false)
    private int totalMarks = 100;

    @Column(name = "percentage")
    private double percentage;

    @Column(name = "grade")
    private String grade;

    @Column(name = "result")
    private String result;

    public Student() {
    }

    public Student(Long id, String studentName, String rollNumber,
                   String department, String subject,
                   int marksObtained, int totalMarks,
                   double percentage, String grade, String result) {

        this.id = id;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.department = department;
        this.subject = subject;
        this.marksObtained = marksObtained;
        this.totalMarks = totalMarks;
        this.percentage = percentage;
        this.grade = grade;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarksObtained() {
        return marksObtained;
    }

    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}