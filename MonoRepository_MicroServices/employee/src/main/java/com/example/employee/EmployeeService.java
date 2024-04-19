package com.example.employee;

import com.example.employee.Client.TownClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final TownClient townClient;
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);

    }

    public Object getEmployeeFullResponse(Integer employeeId) {
        var employee = employeeRepository.findById(employeeId).orElse(Employee.builder().firstName("NOT_FOUND").email("NOT_FOUND").build());
        var town = townClient.getTownById(employee.getTown());
        return EmployeeFullResponse.builder()
                .firstName(employee.getFirstName())
                .email(employee.getEmail())
                .age(employee.getAge())
                .lastName(employee.getLastName())
                .middleName(employee.getMiddleName())
                .EGN(employee.getEGN())
                .department(employee.getDepartment())
                .gender(employee.getGender())
                .phoneNumber(employee.getPhoneNumber())
                .town(town).
                build();
    }
}
