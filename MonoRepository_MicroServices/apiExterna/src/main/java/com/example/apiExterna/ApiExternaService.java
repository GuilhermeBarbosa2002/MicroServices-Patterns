package com.example.apiExterna;


import com.example.apiExterna.Client.ParentClient;
import com.example.apiExterna.Client.StudentClient;
import com.example.apiExterna.Client.TownClient;
import com.example.apiExterna.DTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiExternaService {
    private final TownClient townClient;
    private final ParentClient parentClient;
    private final StudentClient studentClient;
    public Integer addTown(Town town) {
        Integer id = townClient.addTown(town);
        System.err.println("-------------------------------- TOW:   " + id + "----------------------");
        return id;
    }

    public Integer addParent(Parent parent) {
        Integer townId = addTown(parent.getTown()); // get the town id
        ParentDTO parentDTO = ParentDTO.builder().
                firstName(parent.getFirstName()).
                phoneNumber(parent.getPhoneNumber()).
                email(parent.getEmail()).
                middleName(parent.getMiddleName()).
                EGN(parent.getEGN()).
                gender(parent.getGender()).
                lastName(parent.getLastName()).
                age(parent.getAge()).
                town(townId).
                build();

       Integer id = parentClient.addParent(parentDTO);
       System.err.println("-------------------------------- PARENT:   " + id + "----------------------");

       return id;
    }

    public Integer addStudent(Student student) {
        Integer townId = addTown(student.getTown()); //get the town Id
        Integer parentId = addParent(student.getParent()); // get the parent Id
        StudentDTO studentDTO = StudentDTO.builder().
                name(student.getName()).
                email(student.getEmail()).
                town(townId).
                parent(parentId)
                .build();

        studentClient.addStudent(studentDTO);
        return 0;
    }
}
