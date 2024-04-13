package com.example.parent;

import com.example.parent.DTO.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {
    @GetMapping("/parent/{parent-id}")
    List<Student> findAllStudentsByParent(@PathVariable("parent-id") Integer parentId);
}
