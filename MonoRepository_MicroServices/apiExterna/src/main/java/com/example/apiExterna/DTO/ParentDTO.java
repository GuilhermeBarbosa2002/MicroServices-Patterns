package com.example.apiExterna.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParentDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String EGN;
    private Integer age;
    private String gender;
    private String email;
    private Integer town;
}
