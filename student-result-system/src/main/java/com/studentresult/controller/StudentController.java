package com.studentresult.controller;

import com.studentresult.model.Student;
import com.studentresult.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "add-student";
        }

        studentService.saveStudent(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);

        if (student == null) {
            return "redirect:/";
        }

        model.addAttribute("student", student);
        return "update-student";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id,
                                @Valid @ModelAttribute("student") Student student,
                                BindingResult result) {
        if (result.hasErrors()) {
            return "update-student";
        }

        studentService.updateStudent(id, student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @GetMapping("/department")
    public String getByDepartment(@RequestParam String name, Model model) {
        model.addAttribute("students", studentService.getStudentsByDepartment(name));
        model.addAttribute("filterTitle", "Department: " + name);
        return "index";
    }

    @GetMapping("/toppers")
    public String getTopPerformers(Model model) {
        model.addAttribute("students", studentService.getTopPerformers(75));
        model.addAttribute("filterTitle", "Top Performers (Marks ≥ 75)");
        return "index";
    }
}