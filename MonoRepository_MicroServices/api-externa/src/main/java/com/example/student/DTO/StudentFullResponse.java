package com.example.student.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentFullResponse {
    private String name;
    private String email;
    private Parent parent;
    private Town town;
}
