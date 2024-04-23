package com.example.teacher.Subject;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/teachers/subjects")
@RestController
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addSubject(@RequestBody Subject subject){
        subjectService.addSubject(subject);
    }

    @GetMapping
    public ResponseEntity<List<Subject>> getAllSubjects(){
        return ResponseEntity.ok(subjectService.getSubjects());
    }


}
