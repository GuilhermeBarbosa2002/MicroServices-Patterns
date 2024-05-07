package com.example.student;

import com.example.student.Client.ClubClient;
import com.example.student.Client.ParentClient;
import com.example.student.Client.TownClient;
import com.example.student.Client.ViewClient;
import com.example.student.DTO.Club;
import com.example.student.DTO.StudentDTO;
import com.example.student.DTO.StudentFullResponse;
import com.example.student.DTO.Town;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StudentService {

    private final StudentRepository studentRepository;
    private final ParentClient parentClient;
    private final TownClient townClient;
    private final ClubClient clubClient;
    private final ViewClient viewClient;
    public void addStudent(Student student){
        //get the club of Student
        Club club = clubClient.getClubById(student.getClub());
        Town town = club.getTown();

        if(town.getPeople() >= 1000){
           StudentDTO studentDTO = new StudentDTO(student.getName(),student.getEmail());
           viewClient.addStudent(studentDTO);
        }
        studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public List<Student> getAllStudentsByParent(Integer parentId) {
        return studentRepository.findAllByParent(parentId);
    }

    public List<Student> getAllStudentsByTown(Integer townId) {
        return studentRepository.findAllByTown(townId);
    }

    public StudentFullResponse getFullResponseStudent(Integer studentId) {
        var student = studentRepository.findById(studentId).orElse(Student.builder().name("NOT_FOUND").email("NOT_FOUND").build());
        var parent = parentClient.getParentById(student.getParent()); // passamos o parent id e vamos buscar o parent todo
        var town = townClient.getTownById(student.getTown());
        var club = clubClient.getClubById(student.getClub());
        return StudentFullResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .parent(parent)
                .town(town)
                .club(club).
                build();


    }

    public List<Student> getAllStudentsByClub(Integer clubId) {
        return studentRepository.findAllByClub(clubId);
    }

    public void deleteStudentById(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
