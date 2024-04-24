package com.example.apiExterna.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private String name;
    private String email;
    private Integer town;
    private Integer parent;

}