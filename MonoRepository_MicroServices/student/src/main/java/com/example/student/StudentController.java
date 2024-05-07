package com.example.student;

import com.example.student.DTO.StudentFullResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/students")
@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping("parent/{parent-id}")
    public ResponseEntity<List<Student>>getAllStudents(@PathVariable("parent-id") Integer parentId){
        return ResponseEntity.ok(studentService.getAllStudentsByParent(parentId));
    }

    @GetMapping("{student-id}")
    public ResponseEntity<StudentFullResponse>getFullStudent(@PathVariable("student-id") Integer studentId){
        return ResponseEntity.ok(studentService.getFullResponseStudent(studentId));
    }

    @GetMapping("clubs/{club-id}")
    public List<Student> getStudentsByClubId(@PathVariable("club-id") Integer clubId){
     return studentService.getAllStudentsByClub(clubId);
    }

    @DeleteMapping("/{student-id}")
    public void deleteById(@PathVariable("student-id") Integer studentId){
        studentService.deleteStudentById(studentId);
    }



}
