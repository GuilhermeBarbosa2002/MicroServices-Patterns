package com.example.student.Client;


import com.example.student.DTO.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "view-service", url = "${application.config.view-url}")
public interface ViewClient {
    @PostMapping
    void addStudent(@RequestBody StudentDTO student);

}
