package com.example.student.DTO;

import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Town {

    private String country;
    private String name;
    private Integer people;
}
