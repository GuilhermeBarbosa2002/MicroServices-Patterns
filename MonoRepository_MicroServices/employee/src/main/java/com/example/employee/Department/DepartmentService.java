package com.example.employee.Department;

import com.example.employee.Employee;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }
}
