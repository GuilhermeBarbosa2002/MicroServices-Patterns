package com.example.employee;


import com.example.employee.Department.Department;
import com.example.employee.Department.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employees/departments")
@RestController
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getDepartments());
    }


}
