package com.tnsif.student.controller;

import com.tnsif.student.entity.Student;
import com.tnsif.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addStudent(s));
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student s) {
        return service.updateStudent(id, s);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
