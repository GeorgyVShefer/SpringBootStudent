package com.example.demo.repository;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Integer> {
    void deleteByEmail(String email);
    Student findStudentByEmail(String email);
}
