package com.example.teacher;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/teachers")
@RestController
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeacher(@RequestBody Teacher teacher){
        teacherService.addTeacher(teacher);
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getTeachers());
    }

    @GetMapping("{teacher-id}")
    public ResponseEntity<TeacherFullResponse>getFullTeacher(@PathVariable("teacher-id") Integer teacher){
        return ResponseEntity.ok((TeacherFullResponse) teacherService.getTeacherFullResponse(teacher));
    }



}
