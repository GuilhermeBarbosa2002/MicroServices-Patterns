package com.example.apiExterna;


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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addCity(@RequestBody Town town){
        apiExternaService.addTown(town);
    }

    @GetMapping
    public String HelloWorld(){
        return "Ola mundo";
    }





}
