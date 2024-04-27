package com.example.apiExterna.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClubDTO {

    private Integer id;
    private String description;
    private String name;
    private Integer town;

}