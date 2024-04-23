package com.example.teacher.Subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    public void addSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
