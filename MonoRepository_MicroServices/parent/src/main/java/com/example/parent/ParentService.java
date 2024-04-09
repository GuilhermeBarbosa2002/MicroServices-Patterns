package com.example.parent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ParentService {

    private final ParentRepository parentRepository;

    public void addStudent(Parent student){
        parentRepository.save(student);
    }

    public List<Parent> getStudents(){
        return parentRepository.findAll();
    }

}
