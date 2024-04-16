package com.example.parent;

import com.example.parent.Client.StudentClient;
import com.example.parent.Client.TownClient;
import com.example.parent.DTO.FullParentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ParentService {

    private final ParentRepository parentRepository;
    private final StudentClient client; //TEM DE SER FINAL SENÃO NÃO DA
    private final TownClient townClient;
    public void addParent(Parent parent){
        parentRepository.save(parent);
    }

    public List<Parent> getParents(){
        return parentRepository.findAll();
    }

    public FullParentResponse getParentsWithStudents(Integer parentId) {
        var parent = parentRepository.findById(parentId).orElse(Parent.builder().firstName("NOT_FOUND").email("NOT_FOUND").build());
        var students = client.findAllStudentsByParent(parentId); // find the students from the micro-service
        var town = townClient.getTownById(parent.getTown());

        return FullParentResponse.builder()
                .firstName(parent.getFirstName())
                .middleName(parent.getMiddleName())
                .lastName(parent.getLastName())
                .EGN(parent.getEGN())
                .age(parent.getAge())
                .email(parent.getEmail())
                .gender(parent.getGender())
                .phoneNumber(parent.getPhoneNumber())
                .students(students)
                .town(town)
                .build();

    }

    public Parent getParentById(Integer parentId) {
        var parent = parentRepository.findById(parentId).orElse(Parent.builder().firstName("NOT_FOUND").email("NOT_FOUND").build());
        return parent;

    }
}
