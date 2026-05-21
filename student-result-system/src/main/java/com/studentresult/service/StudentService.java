package com.studentresult.service;

import com.studentresult.model.Student;
import com.studentresult.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * StudentService — Service Layer (Business Logic)
 * ═════════════════════════════════════════════════
 *
 * WHY A SERVICE LAYER?
 *   The layered architecture is:
 *
 *   Controller → Service → Repository → Database
 *
 *   Controller: handles HTTP only (reads params, returns responses)
 *   Service:    handles BUSINESS LOGIC (calculations, validations, rules)
 *   Repository: handles DATABASE operations (save, find, delete)
 *
 *   Without a Service layer, the Controller would do too many jobs.
 *   With Service, each layer has exactly ONE responsibility.
 *
 * BUSINESS LOGIC IN THIS SERVICE:
 *   Before saving a student result, we calculate:
 *     1. percentage = (marksObtained / totalMarks) * 100
 *     2. grade      = A+/A/B/C/D/F based on percentage
 *     3. result     = Pass if percentage >= 40, else Fail
 *
 *   This logic belongs in the Service, NOT in the Controller or Repository.
 *
 * @Service:
 *   Marks this class as a Spring-managed bean (component).
 *   Spring creates one instance and injects it wherever needed.
 *
 * @Autowired:
 *   Tells Spring to inject the StudentRepository bean here.
 *   This is Dependency Injection — we don't call new StudentRepository().
 *   Spring manages the object and provides it to us.
 */
@Service
public class StudentService {

    // ── Dependency Injection ───────────────────────────────────────────────────
    // Spring injects the repository — no `new` keyword needed
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Get all student records from the database.
     */
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    /**
     * Get one student by ID.
     * Returns null if not found (handled in Controller).
     */
    public Student getStudentById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        return optional.orElse(null);
    }

    /**
     * Save a new student result.
     * Calculates percentage, grade, and result BEFORE saving.
     *
     * BUSINESS RULES applied here:
     *   percentage = (marks / total) * 100
     *   grade:   >= 90  → A+
     *            >= 80  → A
     *            >= 70  → B
     *            >= 60  → C
     *            >= 40  → D
     *             < 40  → F
     *   result:  >= 40% → Pass
     *             < 40% → Fail
     */
    public Student saveStudent(Student student) {
        // Step 1: Calculate percentage (rounded to 2 decimal places)
        double pct = ((double) student.getMarksObtained() / student.getTotalMarks()) * 100;
        pct = Math.round(pct * 100.0) / 100.0;
        student.setPercentage(pct);

        // Step 2: Calculate grade
        student.setGrade(calculateGrade(pct));

        // Step 3: Determine pass/fail
        student.setResult(pct >= 40.0 ? "Pass" : "Fail");

        // Step 4: Persist to database via Repository
        return studentRepository.save(student);
        // JPA: if student.id == null → INSERT; if id is set → UPDATE
    }

    /**
     * Update an existing student record.
     * Sets the ID on the incoming object so JPA does UPDATE not INSERT.
     */
    public Student updateStudent(Long id, Student updatedStudent) {
        updatedStudent.setId(id);   // Ensure the ID is set for UPDATE
        return saveStudent(updatedStudent); // Reuse the same business logic
    }

    /**
     * Delete a student record by ID.
     */
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    /**
     * Get all students from a specific department.
     */
    public List<Student> getStudentsByDepartment(String department) {
        return studentRepository.findByDepartment(department);
    }

    /**
     * Get all students with a specific result.
     */
    public List<Student> getStudentsByResult(String result) {
        return studentRepository.findByResult(result);
    }

    /**
     * Search students by name (partial, case-insensitive).
     */
    public List<Student> searchByName(String name) {
        return studentRepository.searchByName(name);
    }

    /**
     * Get top performers — students with marks >= given threshold.
     */
    public List<Student> getTopPerformers(int minMarks) {
        return studentRepository.findTopPerformers(minMarks);
    }

    // ── Private Helper ────────────────────────────────────────────────────────
    /**
     * Grade calculation logic.
     * Kept private — only used inside this service.
     */
    private String calculateGrade(double percentage) {
        if (percentage >= 90) return "A+";
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 40) return "D";
        return "F";
    }
}
