package com.example.apiExterna.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club{

    private String description;
    private String name;
    private Integer people;
    private Town town;

}