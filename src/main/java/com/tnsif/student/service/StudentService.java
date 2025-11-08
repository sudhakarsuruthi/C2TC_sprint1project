package com.tnsif.student.service;

import com.tnsif.student.entity.Student;
import com.tnsif.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student addStudent(Student s);
    Student updateStudent(Long id, Student s);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    void deleteStudent(Long id);
}

// ==============================
// Implementation Section
// ==============================
@Service
class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repo;

    @Override
    public Student addStudent(Student s) {
        return repo.save(s);
    }

    @Override
    public Student updateStudent(Long id, Student s) {
        Student existing = repo.findById(id.intValue())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        existing.setName(s.getName());
        existing.setAge(s.getAge());
        existing.setDepartment(s.getDepartment());
        return repo.save(existing);
    }

    @Override
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return repo.findById(id.intValue())
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

    @Override
    public void deleteStudent(Long id) {
        repo.deleteById(id.intValue());
    }
}
