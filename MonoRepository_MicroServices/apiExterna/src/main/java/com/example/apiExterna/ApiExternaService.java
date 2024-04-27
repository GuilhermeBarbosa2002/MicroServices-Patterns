package com.example.apiExterna;


import com.example.apiExterna.Client.ClubClient;
import com.example.apiExterna.Client.ParentClient;
import com.example.apiExterna.Client.StudentClient;
import com.example.apiExterna.Client.TownClient;
import com.example.apiExterna.DTO.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiExternaService {
    private final TownClient townClient;
    private final ParentClient parentClient;
    private final StudentClient studentClient;
    private final ClubClient clubClient;



    public List<Student> getStudentsWithClub1000() {
        List<Club> clubs = clubClient.getAllClubs().getBody();
        List<Club> clubsWith1000= new ArrayList<>();
        List<Student> allStudents = new ArrayList<>();

        for(Club club : clubs){
            if(townClient.getTownById(club.getTown()).getPeople() > 1000){

                clubsWith1000.add(club);
            }
        }

        for(Club club : clubsWith1000){
            List<Student> studentsOfCurrentClub = studentClient.getStudentsByClubId(club.getId());
            allStudents.addAll(studentsOfCurrentClub);
        }

        return allStudents;



    }

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
