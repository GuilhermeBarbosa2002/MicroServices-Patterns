package com.example.employee;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employees")
@RestController
@RequiredArgsConstructor
public class EmployeeControler {
    private final EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }

    @GetMapping("{employee-id}")
    public ResponseEntity<EmployeeFullResponse>getFullStudent(@PathVariable("employee-id") Integer employee){
        return ResponseEntity.ok((EmployeeFullResponse) employeeService.getEmployeeFullResponse(employee));
    }



}
