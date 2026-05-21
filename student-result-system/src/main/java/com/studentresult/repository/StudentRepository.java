package com.studentresult.repository;

import com.studentresult.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByDepartment(String department);

    List<Student> findByResult(String result);

    Optional<Student> findByRollNumber(String rollNumber);

    List<Student> findByDepartmentAndSubject(String department, String subject);

    @Query("SELECT s FROM Student s WHERE s.marksObtained >= :minMarks ORDER BY s.marksObtained DESC")
    List<Student> findTopPerformers(@Param("minMarks") int minMarks);

    @Query("SELECT s FROM Student s WHERE LOWER(s.studentName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Student> searchByName(@Param("name") String name);
}