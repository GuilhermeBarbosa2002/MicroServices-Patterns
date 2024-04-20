package com.example.teacher;

import com.example.teacher.Client.TownClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    private final TownClient townClient;

    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);

    }

    public Object getTeacherFullResponse(Integer teacherId) {
        var teacher = teacherRepository.findById(teacherId).orElse(Teacher.builder().firstName("NOT_FOUND").email("NOT_FOUND").build());
        var town = townClient.getTownById(teacher.getTown());
        return TeacherFullResponse.builder()
                .firstName(teacher.getFirstName())
                .email(teacher.getEmail())
                .age(teacher.getAge())
                .lastName(teacher.getLastName())
                .middleName(teacher.getMiddleName())
                .EGN(teacher.getEGN())
                .subject(teacher.getSubject().getName())
                .gender(teacher.getGender())
                .phoneNumber(teacher.getPhoneNumber())
                .town(town).
                build();
    }
}