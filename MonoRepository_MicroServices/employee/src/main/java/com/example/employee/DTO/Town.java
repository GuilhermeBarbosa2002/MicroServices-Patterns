package com.example.employee.DTO;

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
