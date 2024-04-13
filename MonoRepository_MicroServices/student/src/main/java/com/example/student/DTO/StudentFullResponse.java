package com.example.student;

import jakarta.persistence.Entity;
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
}
