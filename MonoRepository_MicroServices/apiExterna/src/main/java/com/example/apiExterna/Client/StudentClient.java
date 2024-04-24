package com.example.apiExterna.Client;


import com.example.apiExterna.DTO.Parent;
import com.example.apiExterna.DTO.ParentDTO;
import com.example.apiExterna.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void addStudent(@RequestBody StudentDTO studentDTO);

}
