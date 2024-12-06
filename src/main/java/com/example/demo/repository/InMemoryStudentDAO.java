package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO{
    private final List<Student> STUDENTS = new ArrayList<>();
    public List<Student> findAllStudent() {
        return STUDENTS;
    }

    public Student saveStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student getStudentByEmail(String email) {
        return STUDENTS.stream()
                .filter(s -> s.getEmail()
                .equals(email))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        int indexStudent = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);
        if(indexStudent > -1){
            STUDENTS.set(indexStudent,student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        Student studentByEmail = getStudentByEmail(email);
        if(studentByEmail != null){
            STUDENTS.remove(studentByEmail);
        }
    }
}
