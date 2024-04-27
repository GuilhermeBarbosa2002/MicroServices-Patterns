package com.example.apiExterna;


import com.example.apiExterna.Client.ClubClient;
import com.example.apiExterna.Client.ParentClient;
import com.example.apiExterna.Client.StudentClient;
import com.example.apiExterna.Client.TownClient;
import com.example.apiExterna.DTO.*;
import lombok.RequiredArgsConstructor;
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



    public List<StudentDTO> getStudentsWithClub1000(Integer numberPeople) {
        List<ClubDTO> clubs = clubClient.getAllClubs().getBody();
        List<ClubDTO> clubsWith1000= new ArrayList<>();
        List<StudentDTO> allStudents = new ArrayList<>();

        for(ClubDTO club : clubs){
            if(townClient.getTownById(club.getTown()).getPeople() >= numberPeople){
                clubsWith1000.add(club);
                System.err.println("CLUB: " + club.getName());
            }
        }

        for(ClubDTO club : clubsWith1000){
            List<StudentDTO> studentsOfCurrentClub = studentClient.getStudentsByClubId(club.getId());
            System.out.println("STUDENT LENGTH - " + studentsOfCurrentClub.size());
            System.out.println("STUDENT - " + studentsOfCurrentClub.get(0));
            allStudents.addAll(studentsOfCurrentClub);
        }

        return allStudents;



    }

    public Integer addTown(Town town) {
        Integer id = townClient.addTown(town);

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


       return id;
    }

    private Integer addClub(Club club) {
        Integer townId = addTown(club.getTown()); // get the town id
        ClubDTO clubDTO = ClubDTO.builder()
                .name(club.getName())
                .description(club.getDescription())
                .town(townId)
                .build();
        Integer id = clubClient.addClub(clubDTO);

        return id;

    }

    public Integer addStudent(Student student) {
        Integer townId = addTown(student.getTown()); //get the town Id
        Integer parentId = addParent(student.getParent()); // get the parent Id
        Integer clubId = addClub(student.getClub());
        StudentDTO studentDTO = StudentDTO.builder().
                name(student.getName()).
                email(student.getEmail()).
                town(townId).
                parent(parentId)
                .club(clubId)
                .build();

        studentClient.addStudent(studentDTO);
        return 0;
    }


}
