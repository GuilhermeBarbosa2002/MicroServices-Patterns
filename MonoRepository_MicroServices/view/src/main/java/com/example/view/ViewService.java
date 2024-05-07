package com.example.view;

import com.example.view.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewService {

    private final ViewRepository viewRepository;

    public void addStudent(Student student) {
        viewRepository.save(student);
    }

    public List<Student> getStudents() {
        return viewRepository.findAll();
    }
}
