package com.example.apiExterna;


import com.example.apiExterna.DTO.Parent;
import com.example.apiExterna.DTO.Student;
import com.example.apiExterna.DTO.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/apiexterna")
@RestController
@RequiredArgsConstructor
public class ApiExternaController {
    private final ApiExternaService apiExternaService;

    @PostMapping("/town")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTown(@RequestBody Town town){
        apiExternaService.addTown(town);
    }

    @PostMapping("/parent")
    @ResponseStatus(HttpStatus.CREATED)
    public void addParent(@RequestBody Parent parent){
        apiExternaService.addParent(parent);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student){
        apiExternaService.addStudent(student);
    }

    @GetMapping
    public String HelloWorld(){
        return "Ola mundo";
    }





}
