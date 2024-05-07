package com.example.apiExterna.Client;


import com.example.apiExterna.DTO.Parent;
import com.example.apiExterna.DTO.ParentDTO;
import com.example.apiExterna.DTO.Town;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "parent-service", url = "${application.config.parents-url}")
public interface ParentClient {
    @GetMapping("/{parent-id}")
    Parent getParentById(@PathVariable("parent-id") Integer parentId);

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Integer addParent(@RequestBody ParentDTO parent);
    @DeleteMapping("/{student-id}")
    void deleteById(@PathVariable("student-id") Integer studentId);
}
