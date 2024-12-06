package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService service;
    @GetMapping()
    public List<Student> findAllStudent() {
       return service.findAllStudent();
    }

    @PostMapping("save_student")
    public Student saveStudent(@RequestBody Student student){
      return service.saveStudent(student);
    }

    @GetMapping("{email}")
    public Student findByEmail(@PathVariable String email){
        return service.getStudentByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    @Transactional
    public void deleteStudent(@PathVariable String email){
        service.deleteStudent(email);
    }
}
