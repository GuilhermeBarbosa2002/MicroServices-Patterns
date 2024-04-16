package com.example.student;

import com.example.student.Client.ParentClient;
import com.example.student.Client.TownClient;
import com.example.student.DTO.StudentFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final ParentClient parentClient;
    private final TownClient townClient;
    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByParent(Integer parentId) {
        return studentRepository.findAllByParent(parentId);
    }

    public List<Student> getAllStudentsByTown(Integer townId) {
        return studentRepository.findAllByTown(townId);
    }

    public StudentFullResponse getFullResponseStudent(Integer studentId) {
        var student = studentRepository.findById(studentId).orElse(Student.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        var parent = parentClient.getParentById(student.getParent()); // passamos o parent id e vamos buscar o parent todo
        var town = townClient.getTownById(student.getTown());
        return StudentFullResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .parent(parent)
                .town(town).
                build();


    }
}
