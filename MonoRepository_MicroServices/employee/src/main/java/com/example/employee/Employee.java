package com.example.employee;

import com.example.employee.Department.Department;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String EGN;
    private Integer age;
    private String gender;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;
    private String jobTitle;
    private int workHours;

    private Integer town;

}

