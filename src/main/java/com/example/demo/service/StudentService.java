package com.example.demo.service;


import com.example.demo.model.Student;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> findAllStudent();
    Student saveStudent(Student student);
    Student getStudentByEmail(String email);
    Student updateStudent(Student student);
    void deleteStudent(String email);
}
