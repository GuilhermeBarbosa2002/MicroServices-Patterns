package com.example.teacher;

import com.example.teacher.DTO.Town;
import com.example.teacher.Subject.Subject;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherFullResponse {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String EGN;
    private Integer age;
    private String gender;
    private String email;
    private String subject;
    private Town town;
}
