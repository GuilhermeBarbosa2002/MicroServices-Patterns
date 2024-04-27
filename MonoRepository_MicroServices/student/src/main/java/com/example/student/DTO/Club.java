package com.example.student.DTO;

import com.example.student.DTO.Town;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club {


    private String name;
    private String description;
    private Town town;

}
