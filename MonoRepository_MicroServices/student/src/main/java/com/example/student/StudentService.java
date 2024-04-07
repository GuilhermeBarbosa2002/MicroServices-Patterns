package com.example.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.save(student)
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

}
