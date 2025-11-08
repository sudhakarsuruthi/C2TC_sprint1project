package com.tnsif.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tnsif.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
