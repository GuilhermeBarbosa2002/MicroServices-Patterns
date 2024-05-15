package com.example.student.Client;


import com.example.student.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "views", path = "/api/v1/students")
public interface ViewClient {
    @PostMapping
    void addStudent(@RequestBody StudentDTO student);

}
