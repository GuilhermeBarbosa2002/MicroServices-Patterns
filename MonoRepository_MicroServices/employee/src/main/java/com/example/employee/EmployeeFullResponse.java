package com.example.employee;

import com.example.employee.DTO.Town;
import com.example.employee.Department.Department;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeFullResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String EGN;
    private Integer age;
    private String gender;
    private String email;
    private Department department;
    private String jobTitle;
    private int workHours;
    private Town town;
}
