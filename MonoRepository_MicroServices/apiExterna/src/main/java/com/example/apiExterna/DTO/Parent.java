package com.example.apiExterna.DTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parent {
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String EGN;
    private Integer age;
    private String gender;
    private String email;
    private Town town;
}
