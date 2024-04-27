package com.example.apiExterna.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;
    private String email;
    private Town town;
    private Parent parent;
    private Club club;

}
